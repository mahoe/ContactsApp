package com.example.contacts.client.gin;

import com.example.contacts.client.MasterPresenter;
import com.google.gwt.inject.client.AbstractGinModule;

/**
 * Created by hoepfner on 22.09.2014.
 */
public class OurGinModule extends AbstractGinModule {
    @Override
    protected void configure() {
        bind(MasterPresenter.class).asEagerSingleton();
    }
}
