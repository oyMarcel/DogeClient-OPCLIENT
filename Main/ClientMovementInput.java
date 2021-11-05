/*     */ package Main;
/*     */ 
/*     */ import java.text.DecimalFormat;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.entity.EntityPlayerSP;
/*     */ import net.minecraft.client.settings.GameSettings;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.util.MovementInput;
/*     */ 
/*     */ public class ClientMovementInput
/*     */   extends MovementInput
/*     */ {
/*     */   public static boolean sprint = false;
/*     */   private GameSettings gameSettings;
/*  15 */   private int sneakWasPressed = 0;
/*  16 */   private int sprintWasPressed = 0;
/*     */   private EntityPlayerSP player;
/*  18 */   private float originalFlySpeed = -1.0F;
/*  19 */   private float boostedFlySpeed = 1.0F;
/*     */   
/*     */   private Minecraft mc;
/*     */   public boolean flyBoost = false;
/*  23 */   public float flyBoostFactor = 1.0F;
/*  24 */   public int keyHoldTicks = 7;
/*     */   public boolean shiftToggled = false;
/*     */   
/*     */   public ClientMovementInput(GameSettings gameSettings) {
/*  28 */     this.gameSettings = gameSettings;
/*  29 */     this.mc = Minecraft.getMinecraft();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void updatePlayerMoveState() {
/*  35 */     this.player = this.mc.thePlayer;
/*  36 */     this.moveStrafe = 0.0F;
/*  37 */     this.moveForward = 0.0F;
/*     */     
/*  39 */     if (this.gameSettings.keyBindForward.isKeyDown()) {
/*  40 */       this.moveForward++;
/*     */     }
/*     */     
/*  43 */     if (this.gameSettings.keyBindBack.isKeyDown()) {
/*  44 */       this.moveForward--;
/*     */     }
/*     */     
/*  47 */     if (this.gameSettings.keyBindLeft.isKeyDown()) {
/*  48 */       this.moveStrafe++;
/*     */     }
/*     */     
/*  51 */     if (this.gameSettings.keyBindRight.isKeyDown()) {
/*  52 */       this.moveStrafe--;
/*     */     }
/*     */     
/*  55 */     this.jump = this.gameSettings.keyBindJump.isKeyDown();
/*     */     
/*  57 */     this.sneak = this.gameSettings.keyBindSneak.isKeyDown();
/*     */ 
/*     */     
/*  60 */     if (this.sneak) {
/*  61 */       this.moveStrafe *= 0.3F;
/*  62 */       this.moveForward *= 0.3F;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  67 */     if (this.gameSettings.keyBindSprint.isKeyDown()) {
/*  68 */       if (this.sprintWasPressed == 0) {
/*     */         
/*  70 */         if (sprint) {
/*  71 */           this.sprintWasPressed = -1;
/*     */         }
/*  73 */         else if (this.player.capabilities.isFlying) {
/*  74 */           this.sprintWasPressed = this.keyHoldTicks + 1;
/*     */         } else {
/*     */           
/*  77 */           this.sprintWasPressed = 1;
/*     */         } 
/*  79 */         sprint = !sprint;
/*     */       }
/*  81 */       else if (this.sprintWasPressed > 0) {
/*  82 */         this.sprintWasPressed++;
/*     */       } 
/*     */     } else {
/*     */       
/*  86 */       if (this.keyHoldTicks > 0 && this.sprintWasPressed > this.keyHoldTicks) {
/*  87 */         sprint = false;
/*     */       }
/*  89 */       this.sprintWasPressed = 0;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  97 */     if (sprint && this.moveForward == 1.0F && this.player.onGround && !this.player.isUsingItem() && !this.player.isPotionActive(Potion.blindness)) {
/*  98 */       this.player.setSprinting(true);
/*     */     }
/*     */     
/* 101 */     if (this.flyBoost && this.player.capabilities.isCreativeMode && this.player.capabilities.isFlying && this.mc.getRenderViewEntity() == this.player && sprint) {
/*     */       
/* 103 */       if (this.originalFlySpeed < 0.0F || this.player.capabilities.getFlySpeed() != this.boostedFlySpeed) {
/* 104 */         this.originalFlySpeed = this.player.capabilities.getFlySpeed();
/*     */       }
/*     */       
/* 107 */       this.boostedFlySpeed = this.originalFlySpeed * this.flyBoostFactor;
/* 108 */       this.player.capabilities.setFlySpeed(this.boostedFlySpeed);
/*     */       
/* 110 */       if (this.sneak) {
/* 111 */         this.player.motionY -= 0.15D * (this.flyBoostFactor - 1.0F);
/*     */       }
/*     */       
/* 114 */       if (this.jump) {
/* 115 */         this.player.motionY += 0.15D * (this.flyBoostFactor - 1.0F);
/*     */       }
/*     */     }
/*     */     else {
/*     */       
/* 120 */       if (this.player.capabilities.getFlySpeed() == this.boostedFlySpeed) {
/* 121 */         this.player.capabilities.setFlySpeed(this.originalFlySpeed);
/*     */       }
/* 123 */       this.originalFlySpeed = -1.0F;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/* 128 */   private static final DecimalFormat df = new DecimalFormat("#.0");
/*     */   
/*     */   public String getDisplayText() {
/* 131 */     String displayText = "";
/*     */     
/* 133 */     boolean isFlying = this.mc.thePlayer.capabilities.isFlying;
/* 134 */     boolean isRiding = this.mc.thePlayer.isRiding();
/* 135 */     boolean isHoldingSneak = this.gameSettings.keyBindSneak.isKeyDown();
/* 136 */     boolean isHoldingSprint = this.gameSettings.keyBindSprint.isKeyDown();
/*     */     
/* 138 */     if (isFlying) {
/* 139 */       if (this.originalFlySpeed > 0.0F) {
/* 140 */         displayText = String.valueOf(displayText) + "§f[" + ClientInfos.ClientColorMods + "Flying (" + df.format((this.boostedFlySpeed / this.originalFlySpeed)) + "x Boost)" + "§f]";
/*     */       } else {
/* 142 */         displayText = String.valueOf(displayText) + "§f[" + ClientInfos.ClientColorMods + "Flying" + "§f]";
/*     */       } 
/*     */     }
/*     */     
/* 146 */     if (isRiding) {
/* 147 */       displayText = String.valueOf(displayText) + "§f[" + ClientInfos.ClientColorMods + "Riding" + "§f]";
/*     */ 
/*     */     
/*     */     }
/* 151 */     else if (sprint && !isFlying && !isRiding) {
/* 152 */       if (isHoldingSprint) {
/* 153 */         displayText = String.valueOf(displayText) + "§f[" + ClientInfos.ClientColorMods + "Sprinting Held" + "§f]";
/*     */       } else {
/* 155 */         displayText = String.valueOf(displayText) + "§f[" + ClientInfos.ClientColorMods + "Sprinting Toggled" + "§f]";
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 160 */     return displayText.trim();
/*     */   }
/*     */ }
