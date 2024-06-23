package com.example.articlesappandroid.dashboard.presentation.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.articlesappandroid.common.constants.Dim
import com.example.articlesappandroid.dashboard.domain.Article
import com.example.articlesappandroid.dashboard.domain.Filters

@Composable
fun ArticlesList(
    articles:List<Article>,
    actualPage:Int,
    morePagesLoading:Boolean,
    deletingInProgressArticleIds:List<Int>,
    filter:Filters,
){
    LazyColumn(modifier = Modifier.padding(Dim.screenPadding.dp)) {

    }
}