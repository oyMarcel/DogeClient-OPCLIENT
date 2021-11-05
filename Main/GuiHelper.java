/*    */ package Main;
/*    */ 
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.Gui;
/*    */ import net.minecraft.client.gui.ScaledResolution;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ 
/*    */ public class GuiHelper
/*    */ {
/* 11 */   private static Minecraft mc = Minecraft.getMinecraft();
  
/*    */   public static void drawPicture(int x, int y, int width, int height, String location) {
/* 26 */     ResourceLocation loc = new ResourceLocation(location);
/* 27 */     mc.getTextureManager().bindTexture(loc);
/* 28 */     Gui.drawModalRectWithCustomSizedTexture(x, y, 0.0F, 0.0F, width, height, width, height);
/*    */   }
/*    */ 
/*    */   public static void drawBackgroundPicture(int width, int height, String location) {
/* 43 */     ScaledResolution scaledResolution = new ScaledResolution(mc);
/* 44 */     ResourceLocation loc = new ResourceLocation(location);
/* 45 */     mc.getTextureManager().bindTexture(loc);
/* 46 */     Gui.drawModalRectWithCustomSizedTexture(0, 0, 0.0F, 0.0F, scaledResolution.getScaledWidth(), scaledResolution.getScaledHeight(), scaledResolution.getScaledWidth(), scaledResolution.getScaledHeight());
/* 47 */     Gui.drawRect(0, 0, width, height, 1073741824);
/*    */   }
/*    */ }

