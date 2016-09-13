package com.sebangsa.adnanto.pemanasandua.config.otto;

import com.squareup.otto.Bus;

/**
 * Created by adnanto on 9/13/16.
 */
public final class BusProvider {
    private static final Bus BUS = new Bus();

    private BusProvider() {

    }

    public static Bus getInstance() {
        return BUS;
    }
}
