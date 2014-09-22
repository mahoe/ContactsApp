package com.example.contacts.client.gin;

import com.example.contacts.client.MasterPresenter;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

/**
 * Created by hoepfner on 22.09.2014.
 */
@GinModules(OurGinModule.class)
public interface OurGinjector extends Ginjector {

    MasterPresenter getMasterPresenter();
}
