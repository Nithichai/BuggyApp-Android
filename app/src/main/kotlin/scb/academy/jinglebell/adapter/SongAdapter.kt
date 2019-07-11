package scb.academy.jinglebell.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import scb.academy.jinglebell.R
import scb.academy.jinglebell.activity.SongInfoActivity
import scb.academy.jinglebell.extension.setImageUrl
import scb.academy.jinglebell.vo.Song

class SongAdapter(
    private var _songs: List<Song> = listOf(),
    private val onClick: (Song) -> Unit = {
        SongInfoActivity.startActivity(ctx, it)
    },
    private val ctx: Context
) : RecyclerView.Adapter<SongItemViewHolder>() {

    val songs: List<Song>
        get() = _songs

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = SongItemViewHolder(parent)

    override fun onBindViewHolder(holder: SongItemViewHolder, position: Int) {
        holder.bind(_songs[position], onClick, holder.itemView.context)
    }

    override fun getItemCount(): Int {
        return if (songs.count() == 0) {
            0
        } else {
            songs.count() + 1
        }
    }

    fun submitList(list: List<Song>) {
        _songs = list
        notifyDataSetChanged()
    }

}

class SongItemViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_song, parent, false)
) {

    private val ivSongArtwork: ImageView = itemView.findViewById(R.id.iv_song_artwork)
    private val tvSongName: TextView = itemView.findViewById(R.id.tv_song_name)
    private val tvSongArtist: TextView = itemView.findViewById(R.id.tv_song_artist)
    private val tvSongPrice: TextView = itemView.findViewById(R.id.tv_song_price)

    fun bind(song: Song, onClick: (Song) -> Unit = {}, ctx: Context) {
        tvSongName.text = song.name
        tvSongArtist.text = song.artistName
        tvSongPrice.text = "${song.price} ${song.priceCurrency}"
        ivSongArtwork.setImageUrl(song.artworkUrl)

        itemView.setOnClickListener { onClick(song) }
    }

}
