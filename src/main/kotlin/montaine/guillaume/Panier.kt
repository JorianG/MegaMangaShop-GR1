package org.example.montaine.guillaume.montaine.guillaume

class Panier {
    private val mangas = mutableListOf<Manga>()

    fun ajouterManga(manga: Manga) = mangas.add(manga)

    fun retirerManga(manga: Manga) = mangas.remove(manga)

    val total: Double
        get() = mangas.sumOf { it.prix }
}
