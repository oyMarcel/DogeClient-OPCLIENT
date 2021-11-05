/*    */ package Main;
/*    */ 
/*    */ import net.minecraft.client.multiplayer.ServerData;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ public class ServerDataFeatured
/*    */   extends ServerData {
/*  8 */   public static final ResourceLocation ICON = new ResourceLocation("Client/logo1.png");
/*    */   
/*    */   public ServerDataFeatured(String serverName, String serverIp) {
/* 11 */     super(serverName, serverIp, false);
/*    */   }
/*    */ }


