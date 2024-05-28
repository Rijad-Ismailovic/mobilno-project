import com.example.project.backend.models.Fields
import com.example.project.backend.daos.FieldsDao
import com.example.project.backend.repositories.BaseRepository
import kotlinx.coroutines.flow.Flow

class FieldsRepository(private val fieldsDao: FieldsDao): BaseRepository<Fields> {
    override suspend fun insert(t: Fields) = fieldsDao.insert(t)

    override suspend fun update(t: Fields) = fieldsDao.update(t)

    override suspend fun delete(t: Fields) = fieldsDao.delete(t)

    override fun getOneStream(id: Int): Flow<Fields?> = fieldsDao.getField(id)

    fun getFields() = fieldsDao.getFields()
}