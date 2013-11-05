package se.samuelandersson.gdxcommon.systems;

import se.samuelandersson.gdxcommon.components.SpriteComponent;
import se.samuelandersson.gdxcommon.components.VelocityComponent;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import com.badlogic.gdx.Gdx;

public class MovementSystem extends EntityProcessingSystem {

	@Mapper ComponentMapper<VelocityComponent> vm;
	@Mapper ComponentMapper<SpriteComponent> sm;

	public MovementSystem() {
		super(Aspect.getAspectForAll(VelocityComponent.class, SpriteComponent.class));
	}

	@Override
	protected void process(Entity e) {
		float delta = world.getDelta();

		SpriteComponent s = sm.get(e);
		VelocityComponent v = vm.get(e);

		s.x += v.x * delta;
		s.y += v.y * delta;

		// FIXME: this is collision detection; should not be done here.
		if (s.x + s.w > Gdx.graphics.getWidth()) {
			v.x = -v.x;
			s.x = Gdx.graphics.getWidth() - s.w;
		}
		if (s.x < 0) {
			v.x = -v.x;
			s.x = 0;
		}

		if (s.y + s.h > Gdx.graphics.getHeight()) {
			v.y = -v.y;
			s.y = Gdx.graphics.getHeight() - s.h;
		}
		if (s.y < 0) {
			v.y = -v.y;
			s.y = 0;
		}
	}

}
