package com.salty.apps.clipy.domain.usecase

import com.salty.apps.clipy.domain.repository.Repository
import javax.inject.Inject

class UseCase @Inject constructor(private val repository: Repository)