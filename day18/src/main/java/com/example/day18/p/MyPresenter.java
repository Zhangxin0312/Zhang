package com.example.day18.p;

import com.example.day18.bean.Product;
import com.example.day18.contract.Contract;
import com.example.day18.m.MyModel;

public class MyPresenter  implements Contract.MyPresenterInterface {
    Contract.MyModelInterface myModelInterface;
    Contract.MyViewInterface myViewInterface;
    public  MyPresenter(Contract.MyViewInterface myViewInterface){
        myModelInterface=new MyModel();
        this.myViewInterface=myViewInterface;
    }
    @Override
    public void toModel() {
         myModelInterface.toRequest("http://172.17.8.100/ks/product/getCarts?uid=51&tdsourcetag=s_pcqq_aiomsg", new MyModel.MyCallback() {
             @Override
             public void success(Object object) {
                 if(object instanceof Product){
                     Product product= (Product) object;
                     myViewInterface.notifys(product.getData());
                 }
             }
         });
    }
}
