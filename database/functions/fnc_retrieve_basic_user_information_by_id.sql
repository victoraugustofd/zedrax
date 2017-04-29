SELECT U.NAME,
	   U.XP,
	   US.DESC_USER_STATUS,
	   ULE.DESC_USER_LEVEL,
	   ULE.XP_FOR_NEXT_LEVEL,
	   ULO.DT_LOGOUT,
	   (SELECT COUNT(*) FROM EMPIRE E WHERE E.ID_USER = U.ID_USER) AS NUMBER_OF_EMPIRES
			FROM USER U,
				 USER_STATUS US,
				 USER_LEVEL ULE,
				 USER_LOGIN ULO
				WHERE US.ID_USER_STATUS = U.ID_USER_STATUS
				  AND ULE.ID_USER_LEVEL = U.ID_USER_LEVEL
				  AND ULO.ID_USER = U.ID_USER;