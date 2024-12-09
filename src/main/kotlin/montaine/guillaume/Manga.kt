package org.example.montaine.guillaume.montaine.guillaume

data class Manga(val id: String, val titre: String, val prix: Double) {
    init {
        if (prix <= 0) {
            throw IllegalArgumentException("Le prix doit être positif")
        }
        mangas[id] = this
    }

    companion object {
        private val mangas = mutableMapOf<String, Manga>()

        operator fun invoke(id: String): Manga {
            return mangas[id] ?: throw IllegalArgumentException("Manga $id inconnu")
        }
    }
}
