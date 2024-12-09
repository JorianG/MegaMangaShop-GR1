package org.example.montaine.guillaume.montaine.guillaume

data class Manga(val id: String, val titre: String, val prix: Double) {
    init {
        if (mangas.contains(id)) {
            if (mangas[id] != this) {
                throw IllegalArgumentException("Manga $id déjà existant avec des valeurs différentes")
            }
        } else {
            mangas[id] = this
        }
    }

    companion object {
        private val mangas = mutableMapOf<String, Manga>()

        operator fun invoke(id: String): Manga {
            return mangas[id] ?: throw IllegalArgumentException("Manga $id inconnu")
        }
    }
}
