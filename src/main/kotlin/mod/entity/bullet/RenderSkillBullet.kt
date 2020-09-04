package mod.entity.bullet

import mod.Core
import net.minecraft.client.Minecraft
import net.minecraft.client.renderer.entity.Render
import net.minecraft.entity.Entity
import net.minecraft.util.ResourceLocation
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly

@SideOnly(Side.CLIENT)
class RenderSkillBullet() : Render<Entity>(Minecraft.getMinecraft().renderManager) {
	override fun getEntityTexture(entity: Entity): ResourceLocation? {
		return ResourceLocation(Core.ID, "textures/entity/skill_bullet.png")
	}

	override fun doRender(entity: Entity, x: Double, y: Double, z: Double, entityYaw: Float, partialTicks: Float) {
		bindTexture(ResourceLocation(Core.ID, "textures/entity/skill_bullet.png"))

	}
}