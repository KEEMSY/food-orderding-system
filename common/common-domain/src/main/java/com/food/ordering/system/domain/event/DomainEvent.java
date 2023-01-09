package com.food.ordering.system.domain.event;

// 제네릭 타입은 이벤트 개체를 해당 이벤트를 발생시킬 엔터티 유형으로 표시하는 데 도움이 된다.
// 이 이벤트가 시작에 해당한다.
public interface DomainEvent<T> {
}
