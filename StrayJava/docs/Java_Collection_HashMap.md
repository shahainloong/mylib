------

# 源码浅析_Java_Collection_HashMap

> 作者：Echo

HashMap是基于哈希表的 Map 接口的实现。此实现提供所有可选的映射操作，并允许使用 null 值和 null 键。（除了非同步和允许使用 null 之外，HashMap 类与 Hashtable 大致相同。）此类不保证映射的顺序，特别是它不保证该顺序恒久不变。 

此实现假定哈希函数将元素适当地分布在各桶之间，可为基本操作（get 和 put）提供稳定的性能。迭代 collection 视图所需的时间与 HashMap 实例的“容量”（桶的数量）及其大小（键-值映射关系数）成比例。所以，如果迭代性能很重要，则不要将初始容量设置得太高（或将加载因子设置得太低）。 

HashMap 的实例有两个参数影响其性能：初始容量 和加载因子。容量 是哈希表中桶的数量，初始容量只是哈希表在创建时的容量。加载因子 是哈希表在其容量自动增加之前可以达到多满的一种尺度。当哈希表中的条目数超出了加载因子与当前容量的乘积时，则要对该哈希表进行 rehash 操作（即重建内部数据结构），从而哈希表将具有大约两倍的桶数。 

通常，默认加载因子 (.75) 在时间和空间成本上寻求一种折衷。加载因子过高虽然减少了空间开销，但同时也增加了查询成本（在大多数 HashMap 类的操作中，包括 get 和 put 操作，都反映了这一点）。在设置初始容量时应该考虑到映射中所需的条目数及其加载因子，以便最大限度地减少 rehash 操作次数。如果初始容量大于最大条目数除以加载因子，则不会发生 rehash 操作。 

如果很多映射关系要存储在 HashMap 实例中，则相对于按需执行自动的 rehash 操作以增大表的容量来说，使用足够大的初始容量创建它将使得映射关系能更有效地存储。 

注意，此实现不是同步的。如果多个线程同时访问一个哈希映射，而其中至少一个线程从结构上修改了该映射，则它必须 保持外部同步。（结构上的修改是指添加或删除一个或多个映射关系的任何操作；仅改变与实例已经包含的键关联的值不是结构上的修改。）这一般通过对自然封装该映射的对象进行同步操作来完成。如果不存在这样的对象，则应该使用 Collections.synchronizedMap 方法来“包装”该映射。最好在创建时完成这一操作，以防止对映射进行意外的非同步访问，如下所示：

   Map m = Collections.synchronizedMap(new HashMap(...));

由所有此类的“collection 视图方法”所返回的迭代器都是fail-fast（快速失败） 的：在迭代器创建之后，如果从结构上对映射进行修改，除非通过迭代器本身的 remove 方法，其他任何时间任何方式的修改，迭代器都将抛出 ConcurrentModificationException。因此，面对并发的修改，迭代器很快就会完全失败，而不冒在将来不确定的时间发生任意不确定行为的风险。 

注意，迭代器的fail-fast（快速失败）行为不能得到保证，一般来说，存在非同步的并发修改时，不可能作出任何坚决的保证。快速失败迭代器尽最大努力抛出 ConcurrentModificationException。因此，编写依赖于此异常的程序的做法是错误的，正确做法是：迭代器的fail-fast（快速失败）行为应该仅用于检测程序错误

> 以上中文翻译摘自：https://tool.oschina.net/apidocs/apidoc?api=jdk-zh

## Diagram图

![sap_cp_pe_apply_account_for_rjp](./../images/java/java_collection_hashmap_diagram.png)

## 数据结构

HashMap底层采用的是数组和链表组合在一起的链表数组，Hash Map通过扰动函数得到key的hash值

这个hash值并不是一般意义上hashCode值（key.hashCode()），先用key.hashCode()获取到key的hashCode值，再将这个hashCode值做一次扰动处理得到的值就作为这个HashMap的hash值

```java
// 扰动函数就是HashMap的hash()方法
static final int hash(Object key) {
    int h;
    return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
}
```

然后用这个hash值对HashMap的桶（bucket）数量n取余，得到这个value对应桶中的位置，如果当前的位置没有元素的话就直接插入；如果存在元素，就判断存入元素value的值（hash值）和key是否相同，一样就覆盖，不一样要通过拉链法来解决冲突。

**注意：**正常的取余操作是hash  %  n，但是这里采用的是（n -1）& hash，而且n必须是2的m次幂！

## 源码解析

### 成员变量

```java
public class HashMap<K,V> extends AbstractMap<K,V>
    implements Map<K,V>, Cloneable, Serializable {

    /**
     * 默认初始容量 - 必须是2的整数次幂.
     */
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16

    /**
     * 使用有参构造函数时，最大的容量，必须小于2的30次幂.
     */
    static final int MAXIMUM_CAPACITY = 1 << 30;

    /**
     * 构造函数中的默认负载因子.
     */
    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    /**
     * 桶中节点转化成红黑树的阈值，要大于2，大于8时转红黑树.
     */
    static final int TREEIFY_THRESHOLD = 8;

    /**
     * 红黑树的节点数阈值，小于6时红黑树转链表.
     */
    static final int UNTREEIFY_THRESHOLD = 6;

    /**
     * 链转树的最小table容量，桶里有太多节点的话会扩容，至少是4 x TREEIFY_THRESHOLD才能避免冲突.
     * 注意：并不是链表长度大于8就转树，大于8小于64时先扩容，大于64才会转红黑树！！！
     */
    static final int MIN_TREEIFY_CAPACITY = 64;
    
    /**
     * The table, initialized on first use, and resized as
     * necessary. When allocated, length is always a power of two.
     * (We also tolerate length zero in some operations to allow
     * bootstrapping mechanics that are currently not needed.)
     * 初始化时的table，必要时会扩容，分配内存时长度总是2的幂次方，这个是存放元素的数组。
     */
    transient Node<K,V>[] table;

    /**
     * Holds cached entrySet(). Note that AbstractMap fields are used
     * for keySet() and values().
     * 持有的缓存键值对，注意有两个来自AbstractMap的字段keySet() 和 values()
     */
    transient Set<Map.Entry<K,V>> entrySet;

    /**
     * The number of key-value mappings contained in this map.
     * 键值对的个数，不等于数组的长度！
     */
    transient int size;

    /**
     * The number of times this HashMap has been structurally modified
     * Structural modifications are those that change the number of mappings in
     * the HashMap or otherwise modify its internal structure (e.g.,
     * rehash).  This field is used to make iterators on Collection-views of
     * the HashMap fail-fast.  (See ConcurrentModificationException).
     * HashMap被结构性修改的次数，这个字段是用来做HashMap的集合视图的迭代器的fail-fast的。
     */
    transient int modCount;

    /**
     * The next size value at which to resize (capacity * load factor).
     * 扩容阈值，当实际大小超过capacity * load factor时扩容
    int threshold;

    /**
     * The load factor for the hash table.
     * 负载因子
     */
    final float loadFactor;
```

### 内部静态类

### 构造方法

```java
/**
 * Constructs an empty <tt>HashMap</tt> with the default initial capacity
 * (16) and the default load factor (0.75).
 * 使用默认容量16和0.75作为负载因子构造一个空的HashMap。
 */
public HashMap() {
    this.loadFactor = DEFAULT_LOAD_FACTOR; // all other fields defaulted
}
/**
 * Constructs an empty <tt>HashMap</tt> with the specified initial
 * capacity and load factor.
 * 通过指定的容量和负载因子构造一个空的HashMap。
 */
public HashMap(int initialCapacity, float loadFactor) {
    if (initialCapacity < 0)
        throw new IllegalArgumentException("Illegal initial capacity: " +
                                           initialCapacity);
    if (initialCapacity > MAXIMUM_CAPACITY)
        initialCapacity = MAXIMUM_CAPACITY;
    if (loadFactor <= 0 || Float.isNaN(loadFactor))
        throw new IllegalArgumentException("Illegal load factor: " +
                                           loadFactor);
    this.loadFactor = loadFactor;
    this.threshold = tableSizeFor(initialCapacity);
}

/**
 * Constructs an empty <tt>HashMap</tt> with the specified initial
 * capacity and the default load factor (0.75).
 * 通过一个指定的容量，使用默认的负载因子0.75构造一个空的HashMap.
 */
public HashMap(int initialCapacity) {
    this(initialCapacity, DEFAULT_LOAD_FACTOR);
}

/**
 * Constructs a new <tt>HashMap</tt> with the same mappings as the
 * specified <tt>Map</tt>.  The <tt>HashMap</tt> is created with
 * default load factor (0.75) and an initial capacity sufficient to
 * hold the mappings in the specified <tt>Map</tt>.
 * 通过一个指定的Map构造一个新的HashMap。
 */
public HashMap(Map<? extends K, ? extends V> m) {
    this.loadFactor = DEFAULT_LOAD_FACTOR;
    putMapEntries(m, false);
}
```

### put函数

我们只能使用put方法，putVal没有暴露出来给我们使用。

```java
/**
 * Associates the specified value with the specified key in this map.
 * If the map previously contained a mapping for the key, the old
 * value is replaced.
 *
 * @param key key with which the specified value is to be associated
 * @param value value to be associated with the specified key
 * @return the previous value associated with <tt>key</tt>, or
 *         <tt>null</tt> if there was no mapping for <tt>key</tt>.
 *         (A <tt>null</tt> return can also indicate that the map
 *         previously associated <tt>null</tt> with <tt>key</tt>.)
 */
public V put(K key, V value) {
    return putVal(hash(key), key, value, false, true);
}

/**
 * Implements Map.put and related methods.
 *
 * @param hash hash for key
 * @param key the key
 * @param value the value to put
 * @param onlyIfAbsent if true, don't change existing value
 * @param evict if false, the table is in creation mode.
 * @return previous value, or null if none
 */
final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
               boolean evict) {
    Node<K,V>[] tab; Node<K,V> p; int n, i;
    // table为空或者长度为0，进行扩容
    if ((tab = table) == null || (n = tab.length) == 0)
        n = (tab = resize()).length;
    // hash & n取余确定元素在桶中的位置index
    if ((p = tab[i = (n - 1) & hash]) == null)
        // 桶是空的，生成一个节点放在桶里，此时该节点是放在数组里的
        tab[i] = newNode(hash, key, value, null);
    else {
        // 桶不是空的
        Node<K,V> e; K k;
        // p是既存的节点，当
        // 1. p的key和需要存入的key或者，需要存入的key不为空且这个key等于既存的key时
        // 2. 需要存入的key的hash值和既存的hash值相等时
        if (p.hash == hash &&
            ((k = p.key) == key || (key != null && key.equals(k))))
            // 1，2同时满足时，将e指向p，用e来表示
            e = p;
        // p是红黑树时候的判断，p是红黑树表示节点数已经大于8了。
        else if (p instanceof TreeNode)
            e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
        // 链表结构
        else {
            for (int binCount = 0; ; ++binCount) {
                // 既存的节点后面没有节点，可以直接插入新的节点
                if ((e = p.next) == null) {
                    p.next = newNode(hash, key, value, null);
                    // 链表数量大于阈值8，需要树型话，注意并不是转成红黑树，小于64的话是resize扩容，大于64才会转成红黑树！
                    if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                        treeifyBin(tab, hash);
                    break;
                }
                // 此时e就是p，需要存入的hash和既存的hash值相等，key也相等的话就结束
                if (e.hash == hash &&
                    ((k = e.key) == key || (key != null && key.equals(k))))
                    break;
                // 用于遍历桶中的链表，与前面的e = p.next组合，可以遍历链表，这步很厉害
                p = e;
            }
        }
        // key值和key的hash值相等的时候
        if (e != null) { // existing mapping for key
            // 既存的value值
            V oldValue = e.value;
            // onlyIfAbsent为false和oldValue为空时
            if (!onlyIfAbsent || oldValue == null)
                // 覆盖旧值
                e.value = value;
            // 存在LinkedHashMap中的访问后回调函数
            afterNodeAccess(e);
            return oldValue;
        }
    }
    // 结构性修改变量记录值加1
    ++modCount;
    // 实际大小超过阈值，要扩容
    if (++size > threshold)
        resize();
    // 存在LinkedHashMap中的插入后回调函数
    afterNodeInsertion(evict);
    return null;
}
```



## 相关概念

### 位运算&取余



## 参考

- https://tool.oschina.net/apidocs/apidoc?api=jdk-zh
- http://www.ciphermagic.cn/use-and-to-module.html
- [https://github.com/Snailclimb/JavaGuide/blob/master/docs/java/collection/HashMap(JDK1.8)%E6%BA%90%E7%A0%81%2B%E5%BA%95%E5%B1%82%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84%E5%88%86%E6%9E%90.md](https://github.com/Snailclimb/JavaGuide/blob/master/docs/java/collection/HashMap(JDK1.8)源码%2B底层数据结构分析.md)
- https://www.fangzhipeng.com/javainterview/2019/03/15/collections-hashmap.html
- http://www.justdojava.com/2019/03/26/java-HashMap/



