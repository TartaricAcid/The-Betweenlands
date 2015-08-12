package thebetweenlands.client.model.entity;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import thebetweenlands.client.model.MowzieModelBase;
import thebetweenlands.client.model.MowzieModelRenderer;

/**
 * BLTempleGuardian1 - TripleHeadedSheep
 * Created using Tabula 4.1.1
 */
public class ModelMeleeGuardian extends MowzieModelBase {
    public MowzieModelRenderer waist_invisible;
    public MowzieModelRenderer body_base;
    public MowzieModelRenderer chestpiece_right;
    public MowzieModelRenderer chestpiece_left;
    public MowzieModelRenderer legright_1;
    public MowzieModelRenderer legleft_1;
    public MowzieModelRenderer armouredskirt_back;
    public MowzieModelRenderer armouredskirt_right;
    public MowzieModelRenderer armouredskirt_left;
    public MowzieModelRenderer neck;
    public MowzieModelRenderer shoulder_right;
    public MowzieModelRenderer armright_1;
    public MowzieModelRenderer armright_2;
    public MowzieModelRenderer sword_handle;
    public MowzieModelRenderer pommel1;
    public MowzieModelRenderer pommel2;
    public MowzieModelRenderer guard1;
    public MowzieModelRenderer blade1;
    public MowzieModelRenderer guard2;
    public MowzieModelRenderer guard3;
    public MowzieModelRenderer blade2;
    public MowzieModelRenderer shoulder_left;
    public MowzieModelRenderer armleft_1;
    public MowzieModelRenderer armleft_2;
    public MowzieModelRenderer shield_baseplate;
    public MowzieModelRenderer shieldstrap;
    public MowzieModelRenderer edge1a;
    public MowzieModelRenderer edge2a;
    public MowzieModelRenderer edge3a;
    public MowzieModelRenderer edge4a;
    public MowzieModelRenderer button_huehue_butt;
    public MowzieModelRenderer edge1b;
    public MowzieModelRenderer edge2b;
    public MowzieModelRenderer edge3b;
    public MowzieModelRenderer edge4b;
    public MowzieModelRenderer legright_2;
    public MowzieModelRenderer footpiece_right;
    public MowzieModelRenderer legleft_2;
    public MowzieModelRenderer footpiece_left;
    public MowzieModelRenderer armouredskirt_backedge;
    public MowzieModelRenderer headconnection;
    public MowzieModelRenderer headbase;
    public MowzieModelRenderer facepiece;
    public MowzieModelRenderer nose;
    public MowzieModelRenderer helmettop;
    public MowzieModelRenderer helmetside_right;
    public MowzieModelRenderer helmetside_left;
    public MowzieModelRenderer helmet_back;
    public MowzieModelRenderer chest_invisible;
    public MowzieModelRenderer headJoint;

    public ModelMeleeGuardian() {
        this.textureWidth = 256;
        this.textureHeight = 128;
        this.armright_1 = new MowzieModelRenderer(this, 0, 45);
        this.armright_1.setRotationPoint(-1.5F, 4.5F, 0.5F);
        this.armright_1.addBox(-1.5F, -1.0F, -2.5F, 3, 5, 3, 0.0F);
        this.setRotateAngle(armright_1, 0.0F, -0.136659280431156F, 0.0F);
        this.blade2 = new MowzieModelRenderer(this, 9, 91);
        this.blade2.setRotationPoint(0.0F, -16.0F, 0.0F);
        this.blade2.addBox(-0.5F, -2.0F, -0.5F, 1, 2, 2, 0.0F);
        this.legright_2 = new MowzieModelRenderer(this, 60, 13);
        this.legright_2.setRotationPoint(0.0F, 7.1F, 0.0F);
        this.legright_2.addBox(-2.0F, 0.0F, -2.0F, 4, 10, 4, 0.0F);
        this.setRotateAngle(legright_2, 0.0F, 0.0F, -0.045553093477052F);
        this.helmetside_right = new MowzieModelRenderer(this, 100, 56);
        this.helmetside_right.setRotationPoint(-3.0F, 0.0F, 0.0F);
        this.helmetside_right.addBox(-2.0F, 0.0F, -4.99F, 2, 7, 10, 0.0F);
        this.setRotateAngle(helmetside_right, 0.0F, 0.0F, 0.136659280431156F);
        this.guard2 = new MowzieModelRenderer(this, 0, 86);
        this.guard2.setRotationPoint(0.0F, 0.5F, 1.5F);
        this.guard2.addBox(-1.51F, -2.0F, 0.0F, 3, 2, 2, 0.0F);
        this.setRotateAngle(guard2, 0.27314402793711257F, 0.0F, 0.0F);
        this.body_base = new MowzieModelRenderer(this, 0, 0);
        this.body_base.setRotationPoint(0.0F, -6.0F, 2.0F);
        this.body_base.addBox(-4.0F, -2.0F, -5.0F, 8, 8, 6, 0.0F);
        this.shieldstrap = new MowzieModelRenderer(this, 39, 101);
        this.shieldstrap.setRotationPoint(0.0F, 2.0F, 0.0F);
        this.shieldstrap.addBox(-2.5F, 0.0F, -2.5F, 6, 2, 5, 0.0F);
        this.setRotateAngle(shieldstrap, -0.091106186954104F, 0.0F, 0.0F);
        this.armleft_1 = new MowzieModelRenderer(this, 27, 45);
        this.armleft_1.setRotationPoint(1.5F, 4.5F, 0.5F);
        this.armleft_1.addBox(-1.5F, -1.0F, -2.5F, 3, 5, 3, 0.0F);
        this.setRotateAngle(armleft_1, 0.0F, 0.136659280431156F, 0.0F);
        this.guard1 = new MowzieModelRenderer(this, 0, 78);
        this.guard1.setRotationPoint(0.0F, -3.0F, 1.5F);
        this.guard1.addBox(-1.5F, -1.5F, -2.5F, 3, 2, 4, 0.0F);
        this.edge2a = new MowzieModelRenderer(this, 27, 86);
        this.edge2a.setRotationPoint(-5.0F, 0.0F, -2.0F);
        this.edge2a.addBox(-1.0F, -4.0F, 0.0F, 1, 8, 2, 0.0F);
        this.setRotateAngle(edge2a, 0.0F, 0.091106186954104F, 0.0F);
        this.helmettop = new MowzieModelRenderer(this, 100, 43);
        this.helmettop.setRotationPoint(0.0F, -6.0F, 1.0F);
        this.helmettop.addBox(-5.0F, -2.0F, -5.0F, 10, 2, 10, 0.0F);
        this.waist_invisible = new MowzieModelRenderer(this, 140, 0);
        this.waist_invisible.setRotationPoint(0.0F, 7.0F, 0.0F);
        this.waist_invisible.addBox(-4.0F, -2.0F, -3.0F, 8, 4, 6, 0.0F);
        this.armouredskirt_right = new MowzieModelRenderer(this, 60, 46);
        this.armouredskirt_right.setRotationPoint(-2.0F, 0.0F, 0.0F);
        this.armouredskirt_right.addBox(-2.0F, 0.0F, -3.0F, 2, 5, 6, 0.0F);
        this.setRotateAngle(armouredskirt_right, 0.0F, 0.0F, 0.18203784098300857F);
        this.neck = new MowzieModelRenderer(this, 100, 0);
        this.neck.setRotationPoint(0.0F, -6.0F, 0.0F);
        this.neck.addBox(-2.0F, -2.0F, -2.0F, 4, 3, 4, 0.0F);
        this.setRotateAngle(neck, 0.045553093477052F, 0.0F, 0.0F);
        this.footpiece_right = new MowzieModelRenderer(this, 60, 28);
        this.footpiece_right.setRotationPoint(0.0F, 8.0F, -2.0F);
        this.footpiece_right.addBox(-2.01F, 0.0F, -3.0F, 4, 2, 3, 0.0F);
        this.setRotateAngle(footpiece_right, 0.18203784098300857F, 0.0F, 0.0F);
        this.sword_handle = new MowzieModelRenderer(this, 0, 68);
        this.sword_handle.setRotationPoint(0.0F, 6.0F, 0.0F);
        this.sword_handle.addBox(-1.0F, -3.0F, 0.0F, 2, 6, 2, 0.0F);
        this.setRotateAngle(sword_handle, 1.6390387005478748F, 0.0F, 0.0F);
        this.chestpiece_right = new MowzieModelRenderer(this, 0, 18);
        this.chestpiece_right.setRotationPoint(0.0F, 0.0F, -4.0F);
        this.chestpiece_right.addBox(-5.0F, -6.0F, 0.0F, 5, 6, 8, 0.0F);
        this.setRotateAngle(chestpiece_right, -0.045553093477051956F, 0.091106186954104F, 0.0F);
        this.nose = new MowzieModelRenderer(this, 100, 37);
        this.nose.setRotationPoint(0.0F, -0.5F, -3.0F);
        this.nose.addBox(-1.0F, -4.0F, -1.0F, 2, 4, 1, 0.0F);
        this.setRotateAngle(nose, -0.136659280431156F, 0.0F, 0.0F);
        this.armouredskirt_backedge = new MowzieModelRenderer(this, 60, 42);
        this.armouredskirt_backedge.setRotationPoint(0.0F, 5.0F, 0.0F);
        this.armouredskirt_backedge.addBox(-3.0F, 0.0F, -2.0F, 6, 1, 2, 0.0F);
        this.edge4b = new MowzieModelRenderer(this, 48, 86);
        this.edge4b.setRotationPoint(1.0F, 0.0F, 0.0F);
        this.edge4b.addBox(0.0F, -2.0F, 0.0F, 1, 4, 2, 0.0F);
        this.shield_baseplate = new MowzieModelRenderer(this, 27, 68);
        this.shield_baseplate.setRotationPoint(2.0F, 3.0F, -1.0F);
        this.shield_baseplate.addBox(-5.0F, -5.0F, -2.0F, 10, 10, 2, 0.0F);
        this.setRotateAngle(shield_baseplate, 0.091106186954104F, -1.3203415791337103F, 0.0F);
        this.headbase = new MowzieModelRenderer(this, 100, 17);
        this.headbase.setRotationPoint(0.0F, 0.0F, -1.0F);
        this.headbase.addBox(-4.0F, -6.0F, -3.0F, 8, 6, 8, 0.0F);
        this.helmetside_left = new MowzieModelRenderer(this, 125, 56);
        this.helmetside_left.setRotationPoint(3.0F, 0.0F, 0.0F);
        this.helmetside_left.addBox(0.0F, 0.0F, -4.99F, 2, 7, 10, 0.0F);
        this.setRotateAngle(helmetside_left, 0.0F, 0.0F, -0.136659280431156F);
        this.armright_2 = new MowzieModelRenderer(this, 0, 54);
        this.armright_2.setRotationPoint(0.0F, 4.0F, -1.0F);
        this.armright_2.addBox(-2.0F, -1.0F, -2.0F, 4, 8, 4, 0.0F);
        this.setRotateAngle(armright_2, -0.31869712141416456F, -0.045553093477052F, 0.0F);
        this.guard3 = new MowzieModelRenderer(this, 11, 86);
        this.guard3.setRotationPoint(0.0F, 0.5F, -2.5F);
        this.guard3.addBox(-1.49F, -2.0F, -2.0F, 3, 2, 2, 0.0F);
        this.setRotateAngle(guard3, -0.27314402793711257F, 0.0F, 0.0F);
        this.pommel1 = new MowzieModelRenderer(this, 9, 68);
        this.pommel1.setRotationPoint(0.0F, 2.5F, 0.5F);
        this.pommel1.addBox(-1.5F, 0.0F, 0.0F, 3, 2, 2, 0.0F);
        this.setRotateAngle(pommel1, 0.091106186954104F, 0.0F, 0.0F);
        this.chest_invisible = new MowzieModelRenderer(this, 140, 0);
        this.chest_invisible.setRotationPoint(0.0F, -2.0F, -2.0F);
        this.chest_invisible.addBox(-5.0F, -6.0F, -4.0F, 10, 6, 9, 0.0F);
        this.button_huehue_butt = new MowzieModelRenderer(this, 27, 101);
        this.button_huehue_butt.setRotationPoint(0.0F, 0.0F, -3.0F);
        this.button_huehue_butt.addBox(-2.0F, -2.0F, 0.0F, 4, 4, 1, 0.0F);
        this.footpiece_left = new MowzieModelRenderer(this, 80, 28);
        this.footpiece_left.setRotationPoint(0.0F, 8.0F, -2.0F);
        this.footpiece_left.addBox(-1.99F, 0.0F, -3.0F, 4, 2, 3, 0.0F);
        this.setRotateAngle(footpiece_left, 0.18203784098300857F, 0.0F, 0.0F);
        this.blade1 = new MowzieModelRenderer(this, 0, 91);
        this.blade1.setRotationPoint(0.0F, -4.0F, 1.0F);
        this.blade1.addBox(-0.5F, -16.0F, -1.5F, 1, 16, 3, 0.0F);
        this.edge3b = new MowzieModelRenderer(this, 48, 97);
        this.edge3b.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.edge3b.addBox(-2.0F, 0.0F, 0.0F, 4, 1, 2, 0.0F);
        this.armleft_2 = new MowzieModelRenderer(this, 27, 54);
        this.armleft_2.setRotationPoint(0.0F, 4.0F, -1.0F);
        this.armleft_2.addBox(-2.0F, -1.0F, -2.0F, 4, 8, 4, 0.0F);
        this.setRotateAngle(armleft_2, -0.31869712141416456F, 0.045553093477052F, 0.0F);
        this.chestpiece_left = new MowzieModelRenderer(this, 27, 18);
        this.chestpiece_left.setRotationPoint(0.0F, 0.0F, -4.0F);
        this.chestpiece_left.addBox(0.0F, -6.0F, 0.0F, 5, 6, 8, 0.0F);
        this.setRotateAngle(chestpiece_left, -0.045553093477051956F, -0.091106186954104F, 0.0F);
        this.edge3a = new MowzieModelRenderer(this, 27, 97);
        this.edge3a.setRotationPoint(0.0F, 5.0F, -2.0F);
        this.edge3a.addBox(-4.0F, 0.0F, 0.0F, 8, 1, 2, 0.0F);
        this.setRotateAngle(edge3a, 0.091106186954104F, 0.0F, 0.0F);
        this.helmet_back = new MowzieModelRenderer(this, 100, 74);
        this.helmet_back.setRotationPoint(0.0F, 0.0F, 3.0F);
        this.helmet_back.addBox(-5.01F, 0.0F, 0.0F, 10, 8, 2, 0.0F);
        this.setRotateAngle(helmet_back, 0.18203784098300857F, 0.0F, 0.0F);
        this.pommel2 = new MowzieModelRenderer(this, 9, 73);
        this.pommel2.setRotationPoint(0.0F, 2.5F, 0.5F);
        this.pommel2.addBox(-1.51F, 0.0F, -2.0F, 3, 2, 2, 0.0F);
        this.setRotateAngle(pommel2, 0.27314402793711257F, 0.0F, 0.0F);
        this.edge4a = new MowzieModelRenderer(this, 41, 86);
        this.edge4a.setRotationPoint(5.0F, 0.0F, -2.0F);
        this.edge4a.addBox(0.0F, -4.0F, 0.0F, 1, 8, 2, 0.0F);
        this.setRotateAngle(edge4a, 0.0F, -0.091106186954104F, 0.0F);
        this.headconnection = new MowzieModelRenderer(this, 100, 8);
        this.headconnection.setRotationPoint(0.0F, 0, 0F);
        this.headconnection.addBox(-4.0F, 0.0F, -2.0F, 8, 2, 6, 0.0F);
        this.setRotateAngle(headconnection, -0.091106186954104F, 0.0F, 0.0F);
        this.legleft_1 = new MowzieModelRenderer(this, 80, 0);
        this.legleft_1.setRotationPoint(2.0F, 0.0F, 0.0F);
        this.legleft_1.addBox(-1.5F, -1.0F, -1.5F, 3, 9, 3, 0.0F);
        this.setRotateAngle(legleft_1, 0.0F, -0.091106186954104F, -0.045553093477051984F);
        this.edge1a = new MowzieModelRenderer(this, 27, 82);
        this.edge1a.setRotationPoint(0.0F, -5.0F, -2.0F);
        this.edge1a.addBox(-4.0F, -1.0F, 0.0F, 8, 1, 2, 0.0F);
        this.setRotateAngle(edge1a, -0.091106186954104F, 0.0F, 0.0F);
        this.legleft_2 = new MowzieModelRenderer(this, 80, 13);
        this.legleft_2.setRotationPoint(0.0F, 7.1F, 0.0F);
        this.legleft_2.addBox(-2.0F, 0.0F, -2.0F, 4, 10, 4, 0.0F);
        this.setRotateAngle(legleft_2, 0.0F, 0.0F, 0.045553093477052F);
        this.shoulder_right = new MowzieModelRenderer(this, 0, 33);
        this.shoulder_right.setRotationPoint(-5.0F, -5.0F, 4.0F);
        this.shoulder_right.addBox(-3.5F, -1.5F, -3.0F, 4, 6, 5, 0.0F);
        this.setRotateAngle(shoulder_right, 0.18203784098300857F, 0.091106186954104F, 0.136659280431156F);
        this.facepiece = new MowzieModelRenderer(this, 100, 32);
        this.facepiece.setRotationPoint(0.0F, 0.0F, -1.0F);
        this.facepiece.addBox(-3.0F, 0.0F, -2.0F, 6, 2, 2, 0.0F);
        this.edge2b = new MowzieModelRenderer(this, 34, 86);
        this.edge2b.setRotationPoint(-1.0F, 0.0F, 0.0F);
        this.edge2b.addBox(-1.0F, -2.0F, 0.0F, 1, 4, 2, 0.0F);
        this.legright_1 = new MowzieModelRenderer(this, 60, 0);
        this.legright_1.setRotationPoint(-2.0F, 0.0F, 0.0F);
        this.legright_1.addBox(-1.5F, -1.0F, -1.5F, 3, 9, 3, 0.0F);
        this.setRotateAngle(legright_1, 0.0F, 0.091106186954104F, 0.045553093477051984F);
        this.armouredskirt_back = new MowzieModelRenderer(this, 60, 34);
        this.armouredskirt_back.setRotationPoint(0.0F, 0.0F, 3.0F);
        this.armouredskirt_back.addBox(-4.0F, 0.0F, -2.0F, 8, 5, 2, 0.0F);
        this.setRotateAngle(armouredskirt_back, 0.18203784098300857F, 0.0F, 0.0F);
        this.edge1b = new MowzieModelRenderer(this, 48, 82);
        this.edge1b.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.edge1b.addBox(-2.0F, -1.0F, 0.0F, 4, 1, 2, 0.0F);
        this.shoulder_left = new MowzieModelRenderer(this, 27, 33);
        this.shoulder_left.setRotationPoint(5.0F, -5.0F, 4.0F);
        this.shoulder_left.addBox(-0.5F, -1.5F, -3.0F, 4, 6, 5, 0.0F);
        this.setRotateAngle(shoulder_left, 0.18203784098300857F, -0.091106186954104F, -0.136659280431156F);
        this.armouredskirt_left = new MowzieModelRenderer(this, 77, 46);
        this.armouredskirt_left.setRotationPoint(2.0F, 0.0F, 0.0F);
        this.armouredskirt_left.addBox(0.0F, 0.0F, -3.0F, 2, 5, 6, 0.0F);
        this.setRotateAngle(armouredskirt_left, 0.0F, 0.0F, -0.18203784098300857F);
        this.headJoint = new MowzieModelRenderer(this, 0, 0);
        this.headJoint.setRotationPoint(0.0F, -3.0F, -1.0F);
        this.shoulder_right.addChild(this.armright_1);
        this.blade1.addChild(this.blade2);
        this.legright_1.addChild(this.legright_2);
        this.helmettop.addChild(this.helmetside_right);
        this.guard1.addChild(this.guard2);
        this.waist_invisible.addChild(this.body_base);
        this.armleft_2.addChild(this.shieldstrap);
        this.shoulder_left.addChild(this.armleft_1);
        this.sword_handle.addChild(this.guard1);
        this.shield_baseplate.addChild(this.edge2a);
        this.headbase.addChild(this.helmettop);
        this.waist_invisible.addChild(this.armouredskirt_right);
        this.chest_invisible.addChild(this.neck);
        this.legright_2.addChild(this.footpiece_right);
        this.armright_2.addChild(this.sword_handle);
        this.chest_invisible.addChild(this.chestpiece_right);
        this.headbase.addChild(this.nose);
        this.armouredskirt_back.addChild(this.armouredskirt_backedge);
        this.edge4a.addChild(this.edge4b);
        this.armleft_2.addChild(this.shield_baseplate);
        this.headconnection.addChild(this.headbase);
        this.helmettop.addChild(this.helmetside_left);
        this.armright_1.addChild(this.armright_2);
        this.guard1.addChild(this.guard3);
        this.sword_handle.addChild(this.pommel1);
        this.body_base.addChild(this.chest_invisible);
        this.shield_baseplate.addChild(this.button_huehue_butt);
        this.legleft_2.addChild(this.footpiece_left);
        this.sword_handle.addChild(this.blade1);
        this.edge3a.addChild(this.edge3b);
        this.armleft_1.addChild(this.armleft_2);
        this.chest_invisible.addChild(this.chestpiece_left);
        this.shield_baseplate.addChild(this.edge3a);
        this.helmettop.addChild(this.helmet_back);
        this.sword_handle.addChild(this.pommel2);
        this.shield_baseplate.addChild(this.edge4a);
        this.neck.addChild(this.headJoint);
        this.headJoint.addChild(this.headconnection);
        this.waist_invisible.addChild(this.legleft_1);
        this.shield_baseplate.addChild(this.edge1a);
        this.legleft_1.addChild(this.legleft_2);
        this.chestpiece_right.addChild(this.shoulder_right);
        this.headbase.addChild(this.facepiece);
        this.edge2a.addChild(this.edge2b);
        this.waist_invisible.addChild(this.legright_1);
        this.waist_invisible.addChild(this.armouredskirt_back);
        this.edge1a.addChild(this.edge1b);
        this.chestpiece_left.addChild(this.shoulder_left);
        this.waist_invisible.addChild(this.armouredskirt_left);
        
        parts = new MowzieModelRenderer[] {waist_invisible, body_base, chestpiece_right, chestpiece_left, legright_1, legleft_1, armouredskirt_back, armouredskirt_right, armouredskirt_left, neck, shoulder_right, armright_1, armright_2, sword_handle, pommel1, pommel2, guard1, blade1, guard2, guard3, blade2, shoulder_left, armleft_1, armleft_2, shield_baseplate, shieldstrap, edge1a, edge2a, edge3a, edge4a, button_huehue_butt, edge1b, edge2b, edge3b, edge4b, legright_2, footpiece_right, legleft_2, footpiece_left, armouredskirt_backedge, headconnection, headbase, facepiece, nose, helmettop, helmetside_right, helmetside_left, helmet_back, chest_invisible, headJoint};
        setInitPose();
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.waist_invisible.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    @Override
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        faceTarget(headconnection, 1, f3, f4);
    }

    @Override
    public void setLivingAnimations(EntityLivingBase entity, float f, float f1, float partialTicks) {
        setToInitPose();

//        f = entity.ticksExisted + partialTicks;
//        f1 = 0.7f;

        float globalSpeed = 1f;
        float globalDegree = 1.2f;
        float globalHeight = 1.7f;

        waist_invisible.rotationPointY += 1 * f1;
        bob(waist_invisible, 1 * globalSpeed, 1f * globalHeight, false, f, f1);
        swing(chest_invisible, 0.5f * globalSpeed, 0.4f * globalDegree, true, 0, 0, f, f1);
        swing(neck, 0.5f * globalSpeed, 0.4f * globalDegree, false, 0, 0, f, f1);
        walk(waist_invisible, 1 * globalSpeed, 0.1f * globalHeight, false, 0, 0.2f, f, f1);
        walk(headJoint, 1 * globalSpeed, 0.1f * globalHeight, true, 0, -0.2f, f, f1);
        walk(legleft_1, 1 * globalSpeed, 0.1f * globalHeight, true, 0, -0.2f, f, f1);
        walk(legright_1, 1 * globalSpeed, 0.1f * globalHeight, true, 0, -0.2f, f, f1);

        walk(armouredskirt_back, 1 * globalSpeed, 0.3f * globalHeight, false, -1, 0.5f, f, f1);
        flap(armouredskirt_left, 1 * globalSpeed, 0.2f * globalHeight, true, -1, -0.4f, f, f1);
        flap(armouredskirt_right, 1 * globalSpeed, 0.2f * globalHeight, false, -1, 0.4f, f, f1);

        walk(legright_1, 0.5F * globalSpeed, 1F * globalDegree, false, 0, 0.2f, f, f1);
        walk(legleft_1, 0.5F * globalSpeed, 1F * globalDegree, true, 0, 0.2f, f, f1);
        walk(legright_2, 0.5F * globalSpeed, 0.8F * globalDegree, false, -2.2F, 0.6F, f, f1);
        walk(legleft_2, 0.5F * globalSpeed, 0.8F * globalDegree, true, -2.2F, 0.6F, f, f1);

        walk(shoulder_right, 0.5F * globalSpeed, 0.6F * globalDegree, true, 0F, -0.3F * f1, f, f1);
        walk(shoulder_left, 0.5F * globalSpeed, 0.6F * globalDegree, false, 0F, -0.3F * f1, f, f1);
        walk(armright_2, 0.5F * globalSpeed, 0.4F * globalDegree, true, -1F, -0.5F * f1, f, f1);
        walk(armleft_2, 0.5F * globalSpeed, 0.4F * globalDegree, false, -1F, -0.5F * f1, f, f1);
    }
}
