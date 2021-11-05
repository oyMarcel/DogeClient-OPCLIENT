/*    */ package Main;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ public class ClientInfos
/*    */ {
/*  8 */   public static String ClientName = "BEST OP PVP SUPER MINECRAFT PVP CLIENT";
/*    */   
/* 10 */   public static String ClientDev = "§f";
/*    */   
/* 12 */   public static String ClientColorMods = "§c";
/*    */   
/* 14 */   public static Color ClientColor = new Color(219, 46, 46);
/*    */   
/* 16 */   public static int ClientColorInt = (new Color(219, 46, 46)).getRGB();
/*    */   
/* 18 */   public static ResourceLocation CapeLocation = new ResourceLocation("Client/cape.png");
/* 19 */   public static ResourceLocation Wallpaper = new ResourceLocation("Client/wallpaper.png");
/*    */   
/* 21 */   public static int ModType = 1;
/*    */ 
/*    */   
/*    */   public static boolean Featured = true;
/*    */   
/* 26 */   public static String ServerName = String.valueOf(ClientColorMods) + ClientName;
/* 27 */   public static String ServerIp = "play.itsjerryandharry.com";
/*    */ 
/*    */   
/* 30 */   public static int frames = 1;
/* 31 */   static int k = 1;
/*    */ 
/*    */ 
/*    */   
/*    */   public static void onTick() {
/* 36 */     if (k <= 2)
/*    */     {
/*    */       
/* 39 */       k++;
/*    */     }
/*    */     
/* 42 */     if (k == 2) {
/*    */       
/* 44 */       frames++;
/* 45 */       if (frames == 16) {
/* 46 */         frames = 1;
/*    */       }
/*    */       
/* 49 */       k = 1;
/*    */     } 
/*    */   }
/*    */ }

