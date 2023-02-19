package com.company.service.command;

import com.company.entity.Disc;
import com.company.entity.Merch;
import com.company.entity.Product;
import com.sun.istack.internal.Nullable;

import java.util.List;

public class SellItemCommand {
    @Nullable
    private Disc disc;
    @Nullable
    private Merch merch;

    public SellItemCommand(Disc disc, Merch merch) {
        this.disc = disc;
        this.merch = merch;
    }

    public Disc getDisc() {
        return disc;
    }

    public void setDisc(Disc disc) {
        this.disc = disc;
    }

    public Merch getMerch() {
        return merch;
    }

    public void setMerch(Merch merch) {
        this.merch = merch;
    }
}
