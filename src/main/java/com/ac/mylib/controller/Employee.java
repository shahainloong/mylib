package com.ac.mylib.controller;

import java.time.LocalDate;

/** @author hailong.sha */
public class Employee implements Comparable<Employee> {

  private String name;
  private double salary;
  private LocalDate birthday;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getSalary() {
    return salary;
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }

  public LocalDate getBirthday() {
    return birthday;
  }

  public void setBirthday(LocalDate birthday) {
    this.birthday = birthday;
  }

  public Employee() {}

  public Employee(String name, double salary, LocalDate birthday) {
    this.name = name;
    this.salary = salary;
    this.birthday = birthday;
  }

  @Override
  public String toString() {
    return "Employee{"
        + "name='"
        + name
        + '\''
        + ", salary="
        + salary
        + ", birthday="
        + birthday
        + '}';
  }

  @Override
  public int compareTo(Employee o) {
    return Double.compare(salary, o.getSalary());
  }
}
