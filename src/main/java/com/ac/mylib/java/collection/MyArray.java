package com.ac.mylib.java.collection;

/**
 * ArrayList是一个实现了List接口的大小可调控的数组，它实现了List所有的可选择操作，并允许包含null在内的多有元素。除了实现List接口以外，这个类还提供了方法来操纵这个类内部使用的来存储列表的数组的大小（这个类大致和Vector相当，但是这个类是不同步的）。
 * size(),isEmpty(),get(),set(),iterator()和ListItr操作运行在固定时间的，add操作运行在摊余固定时间内，这也就是说，添加n个元素需要O（n）时间，粗略地讲，所有其他的操作都是线性运行地，与Linked List相比，它的常量因子更低。
 * 每个ArrayList实例都有一个容量，这个容量是list中用来存储元素的大小，它最少也是和list的大小一样大。在元素被添加到ArrayList中时，它的容量自动增长，添加一个元素除了有固定摊余时间这一事实外，增长策略的细节没有被指定。
 * 应用程序可以在添加大量元素之前通过ensureCapacity方法增加ArrayList的容量，这个过程可能会减少增量重新分配的大小。
 * 注意到这个ArrayList是不同步的，当多线程同时访问一个ArrayList的实例，并且至少有一个线程修改了这个list的结构，它必须在外部同步。（修改结构指的是：任何一项添加，删除一个或多个元素，或者显示改变备份数组大小，仅仅设定元素的值并不是改变结构）这一般是通过同步一些封装了list的对象来完成的。
 * 如果不存在这样的对象，那么list需要通过使用Collections.synchronizedList方法来包装起来，这最好在创建时做，这样可以防止意外地未同步访问list：
 *     List list = Collections.synchronizedList(new ArrayList(...));
 * 这个类的iterator和listIterator方法返回的iterators是fail-fast的，fail-fast指的是：
 * 在list的迭代器创建之后，除了迭代器自身的add和remove元素意外，以任何方式对list进行结构性修改，迭代器将会抛出一个ConcurrentModificationException异常，这样，在并发修改的情况下，迭代器会快速而干净地失败，而不是在将来会冒着有任意的，不确定的行为的风险。
 * 注意到迭代器的fail-fast行为并不能得到保证，通俗地讲，在未同步的并发修改时不可能做出肯定的保证，fail-fast尽最大努力抛出ConcurrentModificationException异常，因此，编写一个依赖这个异常来保证正确性的程序是错误的想法，迭代器的fail-fast行为应该仅仅用来侦测bugs。
 */
public class MyArray {
    public static void main(String[] args) {
        Object[] num = {1,2,3};
        System.out.println(Object[].class);
        System.out.println(int[].class);
        System.out.println(String.class);
    }
}
