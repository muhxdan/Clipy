package com.salty.apps.clipy.data.repository

import com.salty.apps.clipy.domain.repository.Repository
import io.github.jan.supabase.SupabaseClient
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepositoryImpl @Inject constructor(
    private val supabaseClient: SupabaseClient,
) : Repository