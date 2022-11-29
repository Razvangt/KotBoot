package com.raz.kotBoot.workspace

import com.raz.kotBoot.workspace.application.WorkspaceCreator
import com.raz.kotBoot.workspace.domain.WorkspaceRepository
import org.junit.jupiter.api.BeforeEach

class WorkspaceCreateTest {
    private lateinit var workspaceRepository: WorkspaceRepository
    private lateinit var workspaceCreator: WorkspaceCreator

    @BeforeEach
    fun setUp() {
        workspaceRepository
    }
}