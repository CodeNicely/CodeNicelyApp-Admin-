package com.codenicely.project.groceryappadmin.orders;

import com.codenicely.project.groceryappadmin.orders.model.data.ChangeStatusData;

/**
 * Created by meghal on 9/11/16.
 */

public interface OnOrderStatusChanged {


    void onSuccess(ChangeStatusData changeStatusData);
    void onFailed();
}
