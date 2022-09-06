package com.sussysyrup.smcompat.rei.display;

import com.sussysyrup.smcompat.rei.SmitheeFoundryReiClient;
import com.sussysyrup.smitheesfoundry.registry.BlocksRegistry;
import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.DisplayRenderer;
import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;

import java.util.ArrayList;
import java.util.List;

public class ResonatorCategory implements DisplayCategory<ResonatorDisplay> {

    @Override
    public Renderer getIcon() {
        return EntryStacks.of(BlocksRegistry.ENDER_RESONATOR);
    }

    @Override
    public Text getTitle() {
        return new TranslatableText("rei.smitheesfoundry.resonator");
    }

    @Override
    public CategoryIdentifier<? extends ResonatorDisplay> getCategoryIdentifier() {
        return SmitheeFoundryReiClient.RESONATOR;
    }

    //width 150
    //height 66

    @Override
    public List<Widget> setupDisplay(ResonatorDisplay display, Rectangle bounds) {
        List<Widget> widgets = new ArrayList<>();

        widgets.add(Widgets.createRecipeBase(bounds));
        
        List<EntryIngredient> inputEntries = display.getInputEntries();

        List<EntryIngredient> outputEntries = display.getOutputEntries();

        widgets.add(Widgets.createSlot(new Point(bounds.x + 30, bounds.y + 25)).entry(inputEntries.get(0).get(0)));

        widgets.add(Widgets.createArrow(new Point(bounds.x + 60, bounds.y + 25)).animationDurationMS(20000));

        widgets.add(Widgets.createSlot(new Point(bounds.x + 95, bounds.y + 25)).entry(outputEntries.get(0).get(0)));

        return widgets;
    }

    @Override
    public DisplayRenderer getDisplayRenderer(ResonatorDisplay display) {
        return DisplayCategory.super.getDisplayRenderer(display);
    }
}
