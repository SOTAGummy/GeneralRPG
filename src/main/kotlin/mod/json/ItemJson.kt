package mod.json

data class ItemJson(
		val parent: String,
		val textures: Textures
)

data class Textures(
		val layer0: String
)