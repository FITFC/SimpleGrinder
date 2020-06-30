package com.rumaruka.simplegrinder.client.screen;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import com.rumaruka.simplegrinder.SimpleGrinder;
import com.rumaruka.simplegrinder.common.container.GrinderContainer;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.gui.widget.button.ImageButton;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.ClickType;
import net.minecraft.inventory.container.Slot;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class  CoalGrinderScreen extends ContainerScreen<GrinderContainer> {
    private ResourceLocation GUI = new ResourceLocation(SimpleGrinder.MODID, "textures/gui/container/grind.png");
    private boolean widthTooNarrowIn;
    public CoalGrinderScreen(GrinderContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
        super(screenContainer, inv, titleIn);
    }

    @Override
    protected void func_230450_a_(MatrixStack p_230450_1_, float p_230450_2_, int p_230450_3_, int p_230450_4_) {
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.field_230706_i_.getTextureManager().bindTexture(this.GUI);
        int i = this.guiLeft;
        int j = this.guiTop;
        this.func_238474_b_(p_230450_1_, i, j, 0, 0, this.xSize, this.ySize);
        if (this.container.isBurning()) {
            int k = this.container.getBurnLeftScaled();
            this.func_238474_b_(p_230450_1_, i + 56, j + 36 + 12 - k, 176, 12 - k, 14, k + 1);
        }

        int l = this.container.getCookProgressionScaled();
        this.func_238474_b_(p_230450_1_, i + 79, j + 34, 176, 14, l + 1, 16);
    }
    public void func_231160_c_() {
        super.func_231160_c_();
        this.widthTooNarrowIn = this.field_230708_k_ < 379;

        this.field_238742_p_ = (this.xSize - this.field_230712_o_.func_238414_a_(this.field_230704_d_)) / 2;
    }

    public void func_231023_e_() {
        super.func_231023_e_();
    }

    public void func_230430_a_(MatrixStack p_230430_1_, int p_230430_2_, int p_230430_3_, float p_230430_4_) {
        this.func_230446_a_(p_230430_1_);
        if ( this.widthTooNarrowIn) {
            this.func_230450_a_(p_230430_1_, p_230430_4_, p_230430_2_, p_230430_3_);
        } else {
            super.func_230430_a_(p_230430_1_, p_230430_2_, p_230430_3_, p_230430_4_);
        }

        this.func_230459_a_(p_230430_1_, p_230430_2_, p_230430_3_);
    }
    protected void handleMouseClick(Slot slotIn, int slotId, int mouseButton, ClickType type) {
        super.handleMouseClick(slotIn, slotId, mouseButton, type);
    }

    public boolean func_231046_a_(int p_231046_1_, int p_231046_2_, int p_231046_3_) {
        return super.func_231046_a_(p_231046_1_, p_231046_2_, p_231046_3_);
    }

    protected boolean hasClickedOutside(double mouseX, double mouseY, int guiLeftIn, int guiTopIn, int mouseButton) {
        return mouseX < (double)guiLeftIn || mouseY < (double)guiTopIn || mouseX >= (double)(guiLeftIn + this.xSize) || mouseY >= (double)(guiTopIn + this.ySize);
    }

    public boolean func_231042_a_(char p_231042_1_, int p_231042_2_) {
        return  super.func_231042_a_(p_231042_1_, p_231042_2_);
    }


}
