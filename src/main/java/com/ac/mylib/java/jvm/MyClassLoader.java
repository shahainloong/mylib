package com.ac.mylib.java.jvm;

public class MyClassLoader extends ClassLoader {
    private String name;
    private String path = "d:\\";
    private final String fileType = ".class";

    public MyClassLoader(String name) {
        super();
        this.name = name;
    }

    public MyClassLoader(ClassLoader parent, String name) {
        super(parent);
        this.name = name;
    }

    @Override
    public String toString() {
        return "MyClassLoader{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return super.findClass(name);
    }
}
