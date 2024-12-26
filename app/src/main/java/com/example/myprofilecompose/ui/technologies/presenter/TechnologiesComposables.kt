package com.example.myprofilecompose.ui.technologies.presenter

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SkillList(skills: List<Pair<String, String>>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        items(skills) { skill ->
            SkillItem(name = skill.first, description = skill.second)
        }
    }
}

@Composable
fun SkillItem(name: String, description: String) {
    Card(
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(2.dp, color = Color(0xFFBB86FC)),
        modifier = Modifier.fillMaxWidth(),
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            Text(
                text = name,
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.align(Alignment.Start)
            )
            Divider(
                color = Color(0xFFBB86FC),
                thickness = 1.dp,
                modifier = Modifier.padding(vertical = 8.dp)
            )
            Text(
                text = description,
                style = TextStyle(fontSize = 14.sp),
                modifier = Modifier.align(Alignment.Start)
            )
        }
    }
}
