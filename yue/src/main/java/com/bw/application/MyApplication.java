package com.bw.application;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class MyApplication extends BaseApplication {
    @Override
    public void init() {
        ImageLoaderConfiguration configuration =new   ImageLoaderConfiguration.Builder(this).build() ;
        ImageLoader.getInstance().init(configuration);
    }
}
