package mod.util

object Reference {
	fun getJsonText(name: String): String {
		return "{\n" +
				"  \"parent\": \"item/generated\",\n" +
				"  \"textures\": {\n" +
				"\t\"layer0\": \"general-rpg:items/$name\"\n" +
				"  }\n" +
				"}"
	}
}