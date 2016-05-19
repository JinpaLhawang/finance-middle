package com.jinpalhawang.jambudvipa.financemiddle;

import org.springframework.data.annotation.Id;

public class FinancialAccount {

  @Id
  private String id;

  private String name;

  public FinancialAccount() {}

  public FinancialAccount(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "[" + name + "]";
  }

}
