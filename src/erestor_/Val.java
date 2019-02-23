package erestor_;

public class Val {

//////////////////////////////////////////////////////// S H O P    P R I C E   M U L T I P L I E R S //////////////////////////////////////////////////////////////
static int woodSM = 2;
static int ironSM = 2;
static int goldSM = 3;
static int diamondSM = 5;
static int mithrilSM = 8;
static int foodSM = 2;
static int potionSM = 2;
//////////////////////////////////////////////////////////// D U R A B L I T I E S //////////////////////////////////////////////////////////////////////////////////
static int mithrilDur = (int) (1561 * 0.25) + 1;
static int adamDur = (int) (1561 * 0.30) + 1;
static int voidDur = (int) (1561 * 0.35) + 1;
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

// Ores
static int stickVal = 1;
static int cobbleStoneVal = 2;
static int emeraldVal = 50;
static int sapphireVal = 100;
static int rubyVal = 100;
static int prismarineCrystalsVal = 200;
static int ironOreVal = 5;
static int goldOreVal = 10;
static int diamondOreVal = 15;
static int mithrilOreVal = 30;
static int adamantiteOreVal = 200;
static int voidOreVal = 500;
static int coalVal = 1;
static int magmaVal = 20;

// Misc
static int torch = stickVal + coalVal;
static int divingHelmet = 5000;
static int superMassiveDiamond = 150000;

// Potion
static int emptyBottle = 5;
static int waterBottle = 8;
static int nightVisionPotion = 200;
static int waterBreathingPotion = 100;

// Ingots
static int woodVal = stickVal * 9;
static int stoneVal = (cobbleStoneVal * 8) + (coalVal * 8);
static int ironIngotVal = (ironOreVal * 8) + (coalVal * 16);
static int goldIngotVal = (goldOreVal * 12) + (coalVal * 24);
static int diamondVal = (diamondOreVal * 32) + (coalVal * 40);
static int mithrilIngotVal = (mithrilOreVal * 64) + (coalVal * 64);
static int adamantiteIngotVal = (adamantiteOreVal * 128) + (magmaVal * 24);
static int voidGemVal = (voidOreVal * 512) + (magmaVal * 48);

// Swords
static int wSword = (woodVal * 2) + (stickVal * 1);
static int sSword = (stoneVal * 2) + (stickVal * 1);
static int iSword = (ironIngotVal * 2) + (stickVal * 1);
static int gSword = (goldIngotVal * 2) + (stickVal * 1);
static int dSword = (diamondVal * 2) + (stickVal * 1);
static int mSword = (mithrilIngotVal * 2) + (stickVal * 1);
static int aSword = (adamantiteIngotVal * 2) + (stickVal * 1);
static int vSword = (voidGemVal * 2) + (stickVal * 1);

// Knives
static int wKnife = (woodVal * 1) + (stickVal * 1);
static int sKnife = (stoneVal * 1) + (stickVal * 1);
static int iKnife = (ironIngotVal * 1) + (stickVal * 1);
static int gKnife = (goldIngotVal * 1) + (stickVal * 1);
static int dKnife = (diamondVal * 1) + (stickVal * 1);
static int mKnife = (mithrilIngotVal * 1) + (stickVal * 1);
static int aKnife = (adamantiteIngotVal * 1) + (stickVal * 1);
static int vKnife = (voidGemVal * 1) + (stickVal * 1);

// BattleAxes
static int wBattleaxe = (woodVal * 5) + (stickVal * 2);
static int sBattleaxe = (stoneVal * 5) + (stickVal * 2);
static int iBattleaxe = (ironIngotVal * 5) + (stickVal * 2);
static int gBattleaxe = (goldIngotVal * 5) + (stickVal * 2);
static int dBattleaxe = (diamondVal * 5) + (stickVal * 2);
static int mBattleaxe = (mithrilIngotVal * 5) + (stickVal * 2);
static int aBattleaxe = (adamantiteIngotVal * 5) + (stickVal * 2);
static int vBattleaxe = (voidGemVal * 5) + (stickVal * 2);

// Pickaxes
static int wPickaxe = (woodVal * 3) + (stickVal * 2);
static int sPickaxe = (stoneVal * 3) + (stickVal * 2);
static int iPickaxe = (ironIngotVal * 3) + (stickVal * 2);
static int gPickaxe = (goldIngotVal * 3) + (stickVal * 2);
static int dPickaxe = (diamondVal * 3) + (stickVal * 2);
static int mPickaxe = (mithrilIngotVal * 3) + (stickVal * 2);
static int aPickaxe = (adamantiteIngotVal * 3) + (stickVal * 2);
static int vPickaxe = (voidGemVal * 3) + (stickVal * 2);

// Shields
static int wShield = woodVal * 6;
static int sShield = stoneVal * 6;
static int iShield = ironIngotVal * 6;
static int gShield = goldIngotVal * 6;
static int dShield = diamondVal * 6;
static int mShield = mithrilIngotVal * 6;
static int aShield = adamantiteIngotVal * 6;
static int vShield = voidGemVal * 6;

// Helmets
static int wHelmet = woodVal * 5;
static int iHelmet = ironIngotVal * 5;
static int gHelmet = goldIngotVal * 5;
static int dHelmet = diamondVal * 5;
static int mHelmet = mithrilIngotVal * 5;
static int aHelmet = adamantiteIngotVal * 5;
static int vHelmet = voidGemVal * 5;

// Chestplates
static int wChestplate = woodVal * 8;
static int iChestplate = ironIngotVal * 8;
static int gChestplate = goldIngotVal * 8;
static int dChestplate = diamondVal * 8;
static int mChestplate = mithrilIngotVal * 8;
static int aChestplate = adamantiteIngotVal * 8;
static int vChestplate = voidGemVal * 8;

// Leggings
static int wLeggings = woodVal * 7;
static int iLeggings = ironIngotVal * 7;
static int gLeggings = goldIngotVal * 7;
static int dLeggings = diamondVal * 7;
static int mLeggings = mithrilIngotVal * 7;
static int aLeggings = adamantiteIngotVal * 7;
static int vLeggings = voidGemVal * 7;

// Boots
static int wBoots = woodVal * 4;
static int iBoots = ironIngotVal * 4;
static int gBoots = goldIngotVal * 4;
static int dBoots = diamondVal * 4;
static int mBoots = mithrilIngotVal * 4;
static int aBoots = adamantiteIngotVal * 4;
static int vBoots = voidGemVal * 4;

// Food 
static int steak = 10;
static int porkchop = 7;
static int mutton = 7;
static int chicken = 7;
static int bread = 5;
static int pumpkinPie = 9;
static int cookies = 1;
static int fish = 4;
static int salmon = 6;
static int clownfish = 1;
}