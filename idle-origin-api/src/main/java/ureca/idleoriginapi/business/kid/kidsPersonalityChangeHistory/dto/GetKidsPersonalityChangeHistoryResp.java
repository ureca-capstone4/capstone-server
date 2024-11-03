package ureca.idleoriginapi.business.kid.kidsPersonalityChangeHistory.dto;

import com.ureca.idle.jpa.kidspersonality.KidsPersonalityChangeHistory;

import java.util.List;

public record GetKidsPersonalityChangeHistoryResp(List<KidsPersonalityChangeHistory> histories) {
}
