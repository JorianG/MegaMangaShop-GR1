package org.example.montaine.guillaume.montaine.guillaume

import kotlin.math.round

class Panier(val pays: Pays) {
    private val mangas = mutableListOf<Manga>()

    fun ajouterManga(manga: Manga) = mangas.add(manga)

    fun retirerManga(manga: Manga) = mangas.remove(manga)

    val total: Double
        get() {
            val total = mangas.sumOf { it.prix }
            val withTax = total * (1 + pays.taxe)
            return round(withTax * 100) / 100
        }
}
