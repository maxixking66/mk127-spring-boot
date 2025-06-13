package ir.maktabsharif127.main.mapper;

import ir.maktabsharif127.main.domain.User;
import ir.maktabsharif127.main.dto.UserBriefDTO;
import ir.maktabsharif127.main.dto.UserSaveUpdateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    //    @Mappings(
//            value = {
//                    @Mapping(target = "x", source = "y")
//            }
//    )
    User convertToUser(UserSaveUpdateRequest request);

    UserBriefDTO convertToBriefDTO(User user);
}
