/*    */ package Main;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ public class ClientInfos
/*    */ {
/*  8 */   public static String ClientName = "Doge Client";
/*    */   
/* 10 */   public static String ClientDev = "§f";
/*    */   
/* 12 */   public static String ClientColorMods = "§e";
/*    */   
/* 14 */   public static Color ClientColor = new Color(252, 186, 3);
/*    */   
/* 16 */   public static int ClientColorInt = ClientColor.getRGB();
/*    */   
/* 18 */   public static ResourceLocation CapeLocation = new ResourceLocation("Client/cape.png");
/* 19 */   public static ResourceLocation Wallpaper = new ResourceLocation("Client/wallpaper.png");
/*    */   
/* 21 */   public static int ModType = 1;
/*    */   
/*    */   public static boolean Coords = true;
/*    */   
/*    */   public static boolean FPS = true;
/*    */   
/*    */   public static boolean CPS = true;
/*    */   
/*    */   public static boolean Biom = false;
/*    */   
/*    */   public static boolean Time = false;
/*    */   
/*    */   public static boolean ToggleSprint = true;
/*    */   public static boolean Featured = true;
/* 35 */   public static String ServerName = String.valueOf(ClientColorMods) + ClientName;
/* 36 */   public static String ServerIp = "eu.hivemc.net";
/*    */ 
/*    */   
/* 39 */   public static int frames = 1;
/* 40 */   static int k = 1;
/*    */   public static void onTick() {
/* 42 */     if (k <= 2) {
/* 43 */       k++;
/*    */     }
/* 45 */     if (k == 2) {
/*    */       
/* 47 */       frames++;
/* 48 */       if (frames == 48) {
/* 49 */         frames = 1;
/*    */       }
/* 51 */       k = 1;
/*    */     } 
/*    */   }
/*    */ }
