package com.valleon.inboxapp.emailList;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.List;

@Getter
@Setter
@Table(value = "message_by_user_&_folder")
public class EmailListItem {

    @PrimaryKey
    private EmailListItemKey key;

    @CassandraType(type = CassandraType.Name.LIST, typeArguments = CassandraType.Name.TEXT)
    private List<String> to;

    @CassandraType(type = CassandraType.Name.TEXT)
    private String subject;

    @CassandraType(type = CassandraType.Name.BOOLEAN)
    private boolean isUnread;
}
