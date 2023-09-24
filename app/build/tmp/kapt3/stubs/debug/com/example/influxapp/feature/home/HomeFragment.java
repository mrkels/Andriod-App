package com.example.influxapp.feature.home;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010!\u001a\u00020 2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\"\u001a\u00020 H\u0002J\u0012\u0010#\u001a\u00020 2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J&\u0010&\u001a\u0004\u0018\u00010\'2\u0006\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u001a\u0010,\u001a\u00020 2\u0006\u0010-\u001a\u00020\'2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010.\u001a\u00020 H\u0002J\b\u0010/\u001a\u00020 H\u0002J\b\u00100\u001a\u00020 H\u0002J\b\u00101\u001a\u00020 H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001c\u00a8\u00062"}, d2 = {"Lcom/example/influxapp/feature/home/HomeFragment;", "Landroidx/fragment/app/Fragment;", "()V", "addBtnBudget", "Landroid/widget/Button;", "addBtnExpense", "balance", "Landroid/widget/TextView;", "btnFinancialGoal", "btnGamification", "btnInsight", "budget", "deletedExpense", "Lcom/example/influxapp/database/models/Expense;", "expense", "expenses", "", "expensesAdapter", "Lcom/example/influxapp/adapter/ExpenseAdapter;", "oldExpenses", "recyclerview", "Landroidx/recyclerview/widget/RecyclerView;", "txt_user", "userName", "", "viewModel", "Lcom/example/influxapp/feature/ExpenseViewModel;", "getViewModel", "()Lcom/example/influxapp/feature/ExpenseViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "deleteTransaction", "", "gotoDetailScreen", "initializedRecyclerview", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "setObserver", "showSnackbar", "undoDelete", "updateDashboard", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint
public final class HomeFragment extends androidx.fragment.app.Fragment {
    private android.widget.TextView txt_user;
    private com.example.influxapp.database.models.Expense deletedExpense;
    private java.util.List<com.example.influxapp.database.models.Expense> expenses;
    private java.util.List<com.example.influxapp.database.models.Expense> oldExpenses;
    private android.widget.TextView expense;
    private android.widget.TextView budget;
    private android.widget.TextView balance;
    private android.widget.Button addBtnExpense;
    private android.widget.Button addBtnBudget;
    private android.widget.Button btnGamification;
    private android.widget.Button btnFinancialGoal;
    private android.widget.Button btnInsight;
    private java.lang.String userName = "";
    private final kotlin.Lazy viewModel$delegate = null;
    private androidx.recyclerview.widget.RecyclerView recyclerview;
    private final com.example.influxapp.adapter.ExpenseAdapter expensesAdapter = null;
    
    public HomeFragment() {
        super();
    }
    
    private final com.example.influxapp.feature.ExpenseViewModel getViewModel() {
        return null;
    }
    
    private final void gotoDetailScreen(com.example.influxapp.database.models.Expense expense) {
    }
    
    @java.lang.Override
    public void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setObserver() {
    }
    
    private final void updateDashboard() {
    }
    
    private final void initializedRecyclerview() {
    }
    
    private final void deleteTransaction(com.example.influxapp.database.models.Expense expense) {
    }
    
    private final void showSnackbar() {
    }
    
    private final void undoDelete() {
    }
}