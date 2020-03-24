package com.example.app3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

data class Person(val name: String, val email: String)

// Courtesy of <https://www.fakenamegenerator.com/>
val people = arrayOf(
        Person("Victor S. Balch", "VictorSBalch@rhyta.com"),
        Person("Robert S. Morgan", "RobertSMorgan@jourrapide.com "),
        Person("Corine J. Day", "CorineJDay@armyspy.com "),
        Person("David P. Craig", "DavidPCraig@jourrapide.com "),
        Person("Stella R. Kingsley", "StellaRKingsley@dayrep.com "),
        Person("Leonor C. Coleman", "LeonorCColeman@jourrapide.com"),
        Person("Gregory B. Peck", "GregoryBPeck@jourrapide.com"),
        Person("Alex R. Brady", "AlexRBrady@dayrep.com"),
        Person("Patrice S. Ponce", "PatriceSPonce@rhyta.com"),
        Person("Eva D. Simmons", "EvaDSimmons@jourrapide.com"),
        Person("David V. Higgins", "DavidVHiggins@rhyta.com"),
        Person("Beatrice J. Hernadez", "BeatriceJHernadez@dayrep.com")
)

class MainActivity : AppCompatActivity() {

    class MainActivity : AppCompatActivity() {

        inner class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
            val text1 = item.findViewById<TextView>(R.id.title)
            val text2 = item.findViewById<TextView>(R.id.author)

            init {
                item.setOnClickListener {
                    row.text = "\"${people[adapterPosition].name}\" <${people[adapterPosition].email}>"
                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        books.layoutManager = LinearLayoutManager(this)
        object : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
                val itemView = layoutInflater.inflate(R.layout.book_info, parent, false)
                return RecyclerView.ViewHolder(itemView)
            }

            override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
                holder.text1.text = people[position].name
                holder.text2.text = people[position].email
            }

            override fun getItemCount() = people.size
        }
    }
}
