package com.sussysyrup.smcompat.rei.display;

import com.sussysyrup.smcompat.SMCompatMain;
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
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public class MeltCategory implements DisplayCategory<MeltDisplay> {

   // private static final Identifier TEXTURE = new Identifier(SMCompatMain.MODID, "textures/gui/alloying_display.png");

    @Override
    public Renderer getIcon() {
        return EntryStacks.of(BlocksRegistry.ALLOY_SMELTERY_CONTROLLER);
    }

    @Override
    public Text getTitle() {
        return new TranslatableText("rei.smitheesfoundry.melting");
    }

    @Override
    public CategoryIdentifier<? extends MeltDisplay> getCategoryIdentifier() {
        return SmitheeFoundryReiClient.MELTING;
    }

    //width 150
    //height 66

    @Override
    public List<Widget> setupDisplay(MeltDisplay display, Rectangle bounds) {
        List<Widget> widgets = new ArrayList<>();

        widgets.add(Widgets.createRecipeBase(bounds));


        List<EntryIngredient> inputEntries = display.getInputEntries();

        List<EntryIngredient> outputEntries = display.getOutputEntries();

        widgets.add(Widgets.createSlot(new Point(bounds.x+ 20, bounds.y + 25)).entry(inputEntries.get(0).get(0)));

        widgets.add(Widgets.createArrow(new Point(bounds.x + 60, bounds.y + 25)).animationDurationTicks(30));

        widgets.add(Widgets.createSlot(new Point(bounds.x + 115, bounds.y + 25)).entry(outputEntries.get(0).get(0)));

        return widgets;
    }

    @Override
    public DisplayRenderer getDisplayRenderer(MeltDisplay display) {
        return DisplayCategory.super.getDisplayRenderer(display);
    }
}
