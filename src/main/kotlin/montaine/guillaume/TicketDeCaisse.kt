package montaine.guillaume

import de.huxhorn.sulky.ulid.ULID;
import org.example.montaine.guillaume.montaine.guillaume.Manga


data class TicketDeCaisse(
    val id: String = ULID().nextULID(),
    val totalTtc: Double,
    val taxe: Float,
    val remise: Double,
    val mangas: Map<Manga, Int>
) {
    constructor(
        id: String = ULID().nextULID(),
        totalTtc: Double,
        taxe: Float,
        remise: Double,
        mangas: List<Manga>
    ): this(id, totalTtc, taxe, remise, mangas.groupingBy { it }.eachCount())

    val formatted = buildString {
        appendLine("Ticket de caisse n°$id")
        appendLine("Total TTC: $totalTtc")
        appendLine("Taxe: $taxe")
        appendLine("Remise: $remise")
        appendLine("Mangas:")
        mangas.forEach { (manga, quantity) -> appendLine("  - ${manga.titre} - ${manga.prix}€ x$quantity") }
    }
}
