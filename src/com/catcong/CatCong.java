package com.catcong;

import java.io.File;

import com.catcong.state.Level01State;
import com.jme3.app.SimpleApplication;
import com.jme3.asset.plugins.HttpZipLocator;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.PhysicsSpace;
import com.jme3.bullet.collision.shapes.CapsuleCollisionShape;
import com.jme3.bullet.collision.shapes.CollisionShape;
import com.jme3.bullet.collision.shapes.SphereCollisionShape;
import com.jme3.bullet.control.CharacterControl;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.bullet.objects.PhysicsCharacter;
import com.jme3.bullet.util.CollisionShapeFactory;
import com.jme3.input.KeyInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.light.AmbientLight;
import com.jme3.light.DirectionalLight;
import com.jme3.material.Material;
import com.jme3.material.MaterialList;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.plugins.ogre.OgreMeshKey;
import com.jme3.scene.shape.Box;
import com.jme3.texture.Texture;

public class CatCong extends SimpleApplication implements ActionListener {

	public static void main(String[] args) {
		CatCong app = new CatCong();
		app.start();
	}

	private BulletAppState bulletAppState;
	private CharacterControl player;
	final private Vector3f walkDirection = new Vector3f();
	private static boolean useHttp = false;
	private boolean left = false, right = false, up = false, down = false;
	private Spatial sceneModel;

	public void simpleInitApp() {
		// stateManager.attach(new Level01State(this));
		File file = new File("quake3level.zip");
		if(!file.exists()) {
			useHttp = true;
		}
		cam.setLocation(new Vector3f(0, 5, 0));
		bulletAppState = new BulletAppState();
		stateManager.attach(bulletAppState);
		flyCam.setMoveSpeed(10);
		setupKeys();


		DirectionalLight d1 = new DirectionalLight();
		d1.setColor(ColorRGBA.White.clone().multLocal(2));
		d1.setDirection(new Vector3f(-1, -1, -1).normalize());
		rootNode.addLight(d1);
		
		DirectionalLight sun = new DirectionalLight();
	    sun.setDirection(new Vector3f(1,0,-2).normalizeLocal());
	    sun.setColor(ColorRGBA.White);
	    rootNode.addLight(sun);

		AmbientLight am = new AmbientLight();
		am.setColor(ColorRGBA.White.mult(2));
		rootNode.addLight(am);
		
		/*if(useHttp) {
			assetManager.registerLocator(
					"https://storage.googleapis.com/google-code-archive-downloads/v2/code.google.com/jmonkeyengine/quake3level.zip",
					HttpZipLocator.class);
		}*/
		//MaterialList matList = (MaterialList) assetManager.loadAsset("Scene.material");
		//OgreMeshKey key = new OgreMeshKey("main.meshxml", matList);
		//Node gameLevel = (Node) assetManager.loadAsset(key);
		Box b = new Box(1, 1, 1);
		Geometry geom = new Geometry("Box", b);
		Material mat = new Material(assetManager,  // Create new material and...
			    "Common/MatDefs/Misc/Unshaded.j3md");  // ... specify .j3md file to use (unshaded).
		Texture missTex = assetManager.loadTexture("Interface/Logo/Monkey.png");
		mat.setTexture("ColorMap", missTex);
		geom.setMaterial(mat);               // Use new material on this Geometry.
		//rootNode.attachChild(geom);
		Node gameLevel = new Node("gameLevel");
		gameLevel.attachChild(geom);
		
		Geometry geom2 = geom.clone();
		geom2.setLocalTranslation(new Vector3f(-2, 0, -2));
		gameLevel.attachChild(geom2);
		
		
		
		/** A simple textured cube -- in good MIP map quality. */
	    Box cube1Mesh = new Box( 1f,1f,1f);
	    Geometry cube1Geo = new Geometry("My Textured Box", cube1Mesh);
	    cube1Geo.setLocalTranslation(new Vector3f(-3f,1.1f,0f));
		//gameLevel.setLocalScale(0.1f);
	    //gameLevel.setLocalScale(100.0f, 1.0f, 100.0f);
	    CollisionShape sceneShape =
	    	      CollisionShapeFactory.createMeshShape(gameLevel);
		gameLevel.addControl(new RigidBodyControl(sceneShape, 0));
		CapsuleCollisionShape capsuleShape = new CapsuleCollisionShape(1.5f, 6f, 1);
		bulletAppState.setDebugEnabled(true);
		player = new CharacterControl(capsuleShape, 0.05f);
		player.setJumpSpeed(50);
		player.setFallSpeed(50);
		player.setGravity(100);

		player.setPhysicsLocation(new Vector3f(0, 10, 0));

		rootNode.attachChild(gameLevel);

		getPhysicsSpace().addAll(gameLevel);
		getPhysicsSpace().add(player);
	}

	private PhysicsSpace getPhysicsSpace() {
		return bulletAppState.getPhysicsSpace();
	}
	@Override
	public void simpleUpdate(float tpf) {
		Vector3f camDir = cam.getDirection().clone().multLocal(0.6f);
		Vector3f camLeft = cam.getLeft().clone().multLocal(0.4f);
		walkDirection.set(0, 0, 0);
		if(left) {
			walkDirection.addLocal(camLeft);
		}
		if(right) {
			walkDirection.addLocal(camLeft.negate());
		}
		if(up) {
			walkDirection.addLocal(camDir);
		}
		if(down) {
			walkDirection.addLocal(camDir.negate());
		}
		player.setWalkDirection(walkDirection);
		cam.setLocation(player.getPhysicsLocation());
	}
	@Override
	public void onAction(String binding, boolean value, float tpf) {
		if (binding.equals("Lefts")) {
			if (value) {
				left = true;
			} else {
				left = false;
			}
		}
		else if (binding.equals("Rights")) {
			if (value) {
				right = true;
			} else {
				right = false;
			}
		}
		else if (binding.equals("Ups")) {
			if (value) {
				up = true;
			} else {
				up = false;
			}
		}
		else if (binding.equals("Downs")) {
			if (value) {
				down = true;
			} else {
				down = false;
			}
		}
		else if (binding.equals("Space")) {
			System.out.println(player.onGround());
			if(player.getPhysicsLocation().getY() < 4.31f) {
				//player.setPhysicsLocation(new Vector3f(player.getPhysicsLocation().getX(), 100.0f, player.getPhysicsLocation().getZ()));
			}
			player.jump();
			cam.setLocation(player.getPhysicsLocation());
			System.out.println(player.getPhysicsLocation());
		}
	}



	public void setupKeys() {
		inputManager.addMapping("Lefts", new KeyTrigger(KeyInput.KEY_A));
		inputManager.addMapping("Rights", new KeyTrigger(KeyInput.KEY_D));
		inputManager.addMapping("Ups", new KeyTrigger(KeyInput.KEY_W));
		inputManager.addMapping("Downs", new KeyTrigger(KeyInput.KEY_S));
		inputManager.addMapping("Space", new KeyTrigger(KeyInput.KEY_SPACE));
		inputManager.addListener(this, "Lefts");
		inputManager.addListener(this, "Rights");
		inputManager.addListener(this, "Ups");
		inputManager.addListener(this, "Downs");
		inputManager.addListener(this, "Space");
	}

}