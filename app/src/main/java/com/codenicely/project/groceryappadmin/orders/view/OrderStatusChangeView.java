package com.codenicely.project.groceryappadmin.orders.view;

import com.codenicely.project.groceryappadmin.orders.model.data.ChangeStatusData;

/**
 * Created by meghal on 9/11/16.
 */

public interface OrderStatusChangeView {


    void showDialogLoader(String message, boolean show);

    void onStatusChanged(ChangeStatusData changeStatusData);

    void showMessage(String message);
}
