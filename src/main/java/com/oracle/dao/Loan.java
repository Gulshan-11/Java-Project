package com.oracle.dao;

import java.util.List;

import com.oracle.entity.ActiveLoans;

public interface Loan {
List<ActiveLoans> getAllLoans(int custId);
void save();
}
