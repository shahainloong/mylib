package com.ac.mylib.controller;

import java.time.LocalDate;

public class Manager extends Employee {

  private double bonus;

  public double getBonus() {
    return bonus;
  }

  public void setBonus(double bonus) {
    this.bonus = bonus;
  }

  public Manager() {}

  public Manager(String name, double salary, LocalDate birthday, double bonus) {
    super(name, salary, birthday);
    this.bonus = bonus;
  }
}
