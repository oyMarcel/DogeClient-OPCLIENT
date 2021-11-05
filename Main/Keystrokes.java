/*     */ package Main;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.gui.Gui;
/*     */ import net.minecraft.client.settings.KeyBinding;
/*     */ import org.lwjgl.opengl.GL11;

/*     */ public class Keystrokes
/*     */ {
/*     */   private KeystrokesMode mode;
/*     */   
/*     */   public Keystrokes() {
/* 118 */     this.mode = KeystrokesMode.WASD_SNEAK_MOUSE;
/*     */   }
/*     */   
/* 121 */   public void setMode(KeystrokesMode mode) { this.mode = mode; }
]  
/*     */   public void draw() {
/* 132 */     this.mode = KeystrokesMode.WASD_MOUSE;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 137 */     GL11.glPushMatrix(); byte b; int i;
/*     */     Key[] arrayOfKey;
/* 139 */     for (i = (arrayOfKey = this.mode.getKeys()).length, b = 0; b < i; ) { Key key = arrayOfKey[b];
/*     */       
/* 141 */       int textWidth = getFontRenderer().getStringWidth(key.getName());
/*     */ 
/*     */       
/* 144 */       Gui.drawRect(
/* 145 */           pos.getAbsoluteX() + key.getX(), 
/* 146 */           pos.getAbsoluteY() + key.getY(), 
/* 147 */           pos.getAbsoluteX() + key.getX() + key.getWidth(), 
/* 148 */           pos.getAbsoluteY() + key.getY() + key.getHeight(), 
/* 149 */           key.isDown() ? (new Color(255, 255, 255, 102)).getRGB() : (new Color(0, 0, 0, 150)).getRGB());
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 154 */       getFontRenderer().drawString(
/* 155 */           key.getName(), 
/* 156 */           pos.getAbsoluteX() + key.getX() + key.getWidth() / 2 - textWidth / 2, 
/* 157 */           pos.getAbsoluteY() + key.getY() + key.getHeight() / 2 - 4, 
/* 158 */           key.isDown() ? ClientInfos.ClientColorInt : Color.WHITE.getRGB());
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 163 */       getFontRenderer().drawString("§f", pos.getAbsoluteX() + key.getX() + key.getWidth() / 2 - textWidth / 2, pos.getAbsoluteY() + key.getY() + key.getHeight() / 2 + 4, -1);
/*     */       
/*     */       b++; }
/*     */ 
/*     */     
/* 168 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   public enum KeystrokesMode {
/*     */     WASD((String)new Keystrokes.Key[] { Keystrokes.Key.access$0(), Keystrokes.Key.access$1(), Keystrokes.Key.access$2(), Keystrokes.Key.access$3() }),
/*     */     WASD_MOUSE((String)new Keystrokes.Key[] { Keystrokes.Key.access$0(), Keystrokes.Key.access$1(), Keystrokes.Key.access$2(), Keystrokes.Key.access$3(), Keystrokes.Key.access$4(), Keystrokes.Key.access$5() }),
/*     */     WASD_SNEAK((String)new Keystrokes.Key[] { Keystrokes.Key.access$0(), Keystrokes.Key.access$1(), Keystrokes.Key.access$2(), Keystrokes.Key.access$3(), new Keystrokes.Key("Sneak", (Minecraft.getMinecraft()).gameSettings.keyBindSneak, 1, 41, 58, 18, false) }),
/*     */     WASD_JUMP((String)new Keystrokes.Key[] { Keystrokes.Key.access$0(), Keystrokes.Key.access$1(), Keystrokes.Key.access$2(), Keystrokes.Key.access$3(), Keystrokes.Key.access$4(), Keystrokes.Key.access$5(), new Keystrokes.Key("Jump", (Minecraft.getMinecraft()).gameSettings.keyBindJump, 1, 61, 58, 18, false) }),
/*     */     WASD_SNEAK_MOUSE((String)new Keystrokes.Key[] { Keystrokes.Key.access$0(), Keystrokes.Key.access$1(), Keystrokes.Key.access$2(), Keystrokes.Key.access$4(), Keystrokes.Key.access$5(), Keystrokes.Key.access$3(), new Keystrokes.Key("Sneak", (Minecraft.getMinecraft()).gameSettings.keyBindSneak, 1, 61, 58, 18, false) });
/*     */     private int width = 0;
/*     */     private int height = 0;
/*     */     private final Keystrokes.Key[] keys;
/*     */     
/*     */     KeystrokesMode(Keystrokes.Key... keysIn) {
/*     */       this.keys = keysIn;
/*     */       byte b;
/*     */       int i;
/*     */       Keystrokes.Key[] arrayOfKey;
/*     */       for (i = (arrayOfKey = this.keys).length, b = 0; b < i; ) {
/*     */         Keystrokes.Key key = arrayOfKey[b];
/*     */         this.width = Math.max(this.width, key.getX() + key.getWidth());
/*     */         this.height = Math.max(this.height, key.getY() + key.getHeight());
/*     */         b++;
/*     */       } 
/*     */     }
/*     */     
/*     */     public int getHeight() {
/*     */       return this.height;
/*     */     }
/*     */     
/*     */     public int getWidth() {
/*     */       return this.width;
/*     */     }
/*     */     
/*     */     public Keystrokes.Key[] getKeys() {
/*     */       return this.keys;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class Key {
/*     */     private static final Key W = new Key("W", (Minecraft.getMinecraft()).gameSettings.keyBindForward, 21, 1, 18, 18, false);
/*     */     private static final Key A = new Key("A", (Minecraft.getMinecraft()).gameSettings.keyBindLeft, 1, 21, 18, 18, false);
/*     */     private static final Key S = new Key("S", (Minecraft.getMinecraft()).gameSettings.keyBindBack, 21, 21, 18, 18, false);
/*     */     private static final Key D = new Key("D", (Minecraft.getMinecraft()).gameSettings.keyBindRight, 41, 21, 18, 18, false);
/*     */     private static final Key LMB = new Key("LMB", (Minecraft.getMinecraft()).gameSettings.keyBindAttack, 1, 41, 28, 18, true);
/*     */     private static final Key RMB = new Key("RMB", (Minecraft.getMinecraft()).gameSettings.keyBindUseItem, 31, 41, 28, 18, true);
/*     */     private final String name;
/*     */     private final KeyBinding keyBind;
/*     */     private final int x;
/*     */     private final int y;
/*     */     private final int width;
/*     */     private final int height;
/*     */     private final boolean cps;
/*     */     
/*     */     public Key(String name, KeyBinding keyBind, int x, int y, int width, int height, boolean cps) {
/*     */       this.name = name;
/*     */       this.keyBind = keyBind;
/*     */       this.x = x;
/*     */       this.y = y;
/*     */       this.width = width;
/*     */       this.height = height;
/*     */       this.cps = cps;
/*     */     }
/*     */     
/*     */     public boolean isDown() {
/*     */       return this.keyBind.isKeyDown();
/*     */     }
/*     */     
/*     */     public int getHeight() {
/*     */       return this.height;
/*     */     }
/*     */     
/*     */     public String getName() {
/*     */       return this.name;
/*     */     }
/*     */     
/*     */     public int getWidth() {
/*     */       return this.width;
/*     */     }
/*     */     
/*     */     public int getX() {
/*     */       return this.x;
/*     */     }
/*     */     
/*     */     public int getY() {
/*     */       return this.y;
/*     */     }
/*     */   }
/*     */   
/*     */   public FontRenderer getFontRenderer() {
/*     */     return (Minecraft.getMinecraft()).fontRendererObj;
/*     */   }
/*     */ }
