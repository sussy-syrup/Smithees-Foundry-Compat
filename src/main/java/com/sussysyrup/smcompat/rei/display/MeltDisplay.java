package com.sussysyrup.smcompat.rei.display;

import com.sussysyrup.smcompat.rei.SmitheeFoundryReiClient;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.entry.EntryIngredient;

import java.util.List;

public class MeltDisplay extends BasicDisplay {

    public MeltDisplay(List<EntryIngredient> inputs, List<EntryIngredient> outputs) {
        super(inputs, outputs);
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return SmitheeFoundryReiClient.MELTING;
    }
}
