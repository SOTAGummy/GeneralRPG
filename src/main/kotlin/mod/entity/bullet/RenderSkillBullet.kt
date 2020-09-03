package mod.entity.bullet

import mod.Core
import net.minecraft.client.renderer.entity.Render
import net.minecraft.client.renderer.entity.RenderManager
import net.minecraft.entity.Entity
import net.minecraft.util.ResourceLocation
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly

@SideOnly(Side.CLIENT)
class RenderSkillBullet(renderManager: RenderManager) : Render<Entity>(renderManager){
	override fun getEntityTexture(entity: Entity): ResourceLocation? {
		return ResourceLocation(Core.ID, "textures/entity/skill_bullet.png")
	}
}