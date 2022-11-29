package com.raz.kotBoot.workspace

import com.raz.kotBoot.shared.Either
import com.raz.kotBoot.shared.Left
import com.raz.kotBoot.shared.Right
import org.springframework.stereotype.Service
import java.lang.Exception
import java.lang.IllegalArgumentException
import java.util.UUID

@Service
class WorkspaceService(val db : WorkspaceRepository){
    fun findWorkspace() : Iterable<Workspace> = db.findAll()
    fun findById( id : String) : Either<WorkspaceError,Workspace> = db.find(id).fold(
        ifRight = {
                it?.let {
                    Right(it)
                } ?: Left(WorkspaceNotFoundError(id))
        },
        ifLeft = {
            Left(it)
        }
    )
    fun post(workspace: Workspace){
        checkName(workspace.name)
        db.save(workspace)
    }



    private fun checkName(name : String){
        if(name.isBlank() || name.isEmpty()) throw InvalidWorkspaceNameException(name)
    }

    private fun checkId(id : String){
        try {
            UUID.fromString(id)
        } catch (exception : Exception){
            throw InvalidWorkspaceIdException(id,exception)
        }
    }
    fun update(workspace: Workspace){
        workspace.id ?: throw IllegalArgumentException()
        checkName(workspace.name)
        checkId(workspace.id)
        if(db.findById(workspace.id).isEmpty)
            throw WorkspaceNotFoundException(workspace.id)
        db.save(workspace)
    }
}
