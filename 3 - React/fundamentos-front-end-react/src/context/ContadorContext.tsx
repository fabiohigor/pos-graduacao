"use client";

import { createContext, Dispatch, ReactNode, SetStateAction, useEffect, useState } from "react";

type ContadorType = number | null;

type ContadorContextType = {
    contador: ContadorType;
    setContador: Dispatch<SetStateAction<ContadorType>>;
};



export const ContadorContext = createContext<ContadorContextType>({
    contador: 0,
    setContador: () => {},
});

export default function  ContadorProvider ({ 
    children, 
}: {
    children: ReactNode;
}) {

    const [contador, setContador] = useState<ContadorType>(null);
    useEffect(() => {
        const contadorSessionStore = sessionStorage.getItem("contador") ?? 0;
        
        if(contadorSessionStore !== null && contadorSessionStore !== undefined) {
            setContador(Number(contadorSessionStore));
        }
    }, []);

    useEffect(() => {
        if(contador){
            sessionStorage.setItem("contador", contador.toString());
        }       
    }, [contador]);

    return  (
            <ContadorContext.Provider value={{contador, setContador }}>
                {children}
            </ContadorContext.Provider>
    );
}