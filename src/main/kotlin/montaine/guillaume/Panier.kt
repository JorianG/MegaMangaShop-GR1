package org.example.montaine.guillaume.montaine.guillaume

import montaine.guillaume.TicketDeCaisse
import kotlin.math.round

class Panier(val pays: Pays) {
    private val mangas = mutableListOf<Manga>()

    fun ajouterManga(manga: Manga, quantity: Int = 1) {
        if (quantity < 1) throw IllegalArgumentException("La quantité doit être supérieure à 0")
        repeat(quantity) { mangas.add(manga) }
    }

    fun retirerManga(manga: Manga, quantity: Int = 1) {
        if (quantity < 1) throw IllegalArgumentException("La quantité doit être supérieure à 0")
        repeat(quantity) { mangas.remove(manga) }
    }

    private val ttc: Double get() = mangas.sumOf { it.prix } * (1 + pays.taxe)

    private val remise: Double
        get() = when {
            ttc <= 150 -> .0
            ttc <= 200 -> ttc * .02
            ttc <= 300 -> ttc * .03
            ttc <= 500 -> ttc * .05
            ttc <= 1000 -> ttc * .07
            else -> ttc * .1
        }

    val total: Double
        get() {
            return round((ttc - remise) * 100) / 100
        }

    val ticket: TicketDeCaisse get() = TicketDeCaisse(
        totalTtc = ttc,
        taxe = pays.taxe,
        remise = remise,
        mangas = mangas
    )
}
